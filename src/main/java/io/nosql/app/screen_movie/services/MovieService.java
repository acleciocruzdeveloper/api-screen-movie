package io.nosql.app.screen_movie.services;

import io.nosql.app.screen_movie.domain.Filmes;
import io.nosql.app.screen_movie.dto.MovieDTO;
import io.nosql.app.screen_movie.repositories.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final static Logger logger = LoggerFactory.getLogger(MovieService.class);
    private final IMovieRepository repository;

    public MovieDTO movieRegistry(MovieDTO data) {
        logger.info("REGISTRY NEW MOVIE -> {}", data);
        Filmes filmes = repository.save(Filmes.converterToMovieDomain(data));
        return MovieDTO.converterMovieModel(filmes);
    }


    public List<Filmes> findAllMovies() {
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
