package io.nosql.app.screen_movie.services;

import io.nosql.app.screen_movie.domain.Movie;
import io.nosql.app.screen_movie.dto.MovieDTO;
import io.nosql.app.screen_movie.repositories.IMovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final static Logger logger = LoggerFactory.getLogger(MovieService.class);
    private final IMovieRepository repository;

    public MovieService(IMovieRepository repository) {
        this.repository = repository;
    }


    public MovieDTO movieRegistry(MovieDTO data) {
        logger.info("REGISTRY NEW MOVIE -> {}", data);
        Movie movie = repository.save(Movie.converterToMovieDomain(data));
        return MovieDTO.converterMovieModel(movie);
    }


    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

    public MovieDTO findById(String id) {
        return repository.findById(id).map(MovieDTO::converterMovieModel)
                .orElseThrow(() -> new RuntimeException("Object not found!"));

    }

    public void removeMovie(String id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
