package io.nosql.app.screen_movie.repositories;

import io.nosql.app.screen_movie.domain.Filmes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMovieRepository extends MongoRepository<Filmes, String> {
}
