package io.nosql.app.screen_movie.infra.score;

import io.nosql.app.screen_movie.domain.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScoreRepository extends MongoRepository<Score, String> {
}
