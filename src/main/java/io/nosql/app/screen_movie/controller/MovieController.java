package io.nosql.app.screen_movie.controller;

import io.nosql.app.screen_movie.domain.Movie;
import io.nosql.app.screen_movie.dto.MovieDTO;
import io.nosql.app.screen_movie.services.MovieService;
import io.nosql.app.screen_movie.utils.UriBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final UriBuilder uriBuilder;

    private final MovieService movieService;

    @RequestMapping(value = UriBuilder.URI_MOVIES, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok().body(movieService.findAllMovies());
    }

    @RequestMapping(value = UriBuilder.URI_MOVIE_ID, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable String id) {
        return ResponseEntity.ok().body(movieService.findById(id));
    }

    @RequestMapping(value = UriBuilder.URI_REGISTER_MOVIES, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MovieDTO> registry(@Valid @RequestBody MovieDTO data) {
        MovieDTO movieDTO = movieService.movieRegistry(data);
        URI uri = uriBuilder.builderUriWithId(UriBuilder.URI_MOVIE_ID, movieDTO.id());
        return ResponseEntity.created(uri).body(movieDTO);
    }

    @RequestMapping(value = UriBuilder.URI_DELETE_MOVIE, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteMovie(@PathVariable String id) {
        movieService.removeMovie(id);
        return ResponseEntity.noContent().build();
    }
}
