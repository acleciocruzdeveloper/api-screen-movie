package io.nosql.app.screen_movie.controller;

import io.nosql.app.screen_movie.domain.Movie;
import io.nosql.app.screen_movie.services.MovieService;
import io.nosql.app.screen_movie.dto.MovieDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok().body(movieService.findAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable String id) {
        return ResponseEntity.ok().body(movieService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MovieDTO> registry(@Valid @RequestBody MovieDTO data) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(data.id())
                .toUri();

        return ResponseEntity.created(uri).body(movieService.movieRegistry(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String id) {
        movieService.removeMovie(id);
        return ResponseEntity.noContent().build();
    }


}
