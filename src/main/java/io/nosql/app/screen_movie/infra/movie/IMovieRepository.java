package io.nosql.app.screen_movie.infra.movie;

import io.nosql.app.screen_movie.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMovieRepository extends MongoRepository<Movie, String> {
}
