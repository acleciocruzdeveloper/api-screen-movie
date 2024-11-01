package io.nosql.app.screen_movie.controller;

import io.nosql.app.screen_movie.domain.Filmes;
import io.nosql.app.screen_movie.dto.MovieDTO;
import io.nosql.app.screen_movie.services.MovieService;
import io.nosql.app.screen_movie.utils.UriComponent;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilmesController {

    private final UriComponent uriComponent;

    private final MovieService movieService;

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMERS')")
    @RequestMapping(value = UriComponent.URI_MOVIES, method = RequestMethod.GET)
    public ResponseEntity<List<Filmes>> getAllMovies(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        return ResponseEntity.ok().body(movieService.findAllMovies());
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMERS')")
    @RequestMapping(value = UriComponent.URI_MOVIE_ID, method = RequestMethod.GET)
    public ResponseEntity<MovieDTO> getMovieById(
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable String id) {
        return ResponseEntity.ok().body(movieService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = UriComponent.URI_REGISTER_MOVIES, method = RequestMethod.POST)
    public ResponseEntity<MovieDTO> registry(@Valid @RequestBody MovieDTO data) {
        MovieDTO movieDTO = movieService.movieRegistry(data);
        URI uri = uriComponent.builderUriWithId(UriComponent.URI_MOVIE_ID, movieDTO.id());
        return ResponseEntity.created(uri).body(movieDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = UriComponent.URI_DELETE_MOVIE, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMovie(@PathVariable String id) {
        movieService.removeMovie(id);
        return ResponseEntity.noContent().build();
    }
}
