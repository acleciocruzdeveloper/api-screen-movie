package io.nosql.app.screen_movie.repositories;

import io.nosql.app.screen_movie.domain.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsersRepository extends MongoRepository<Usuarios, String> {
}
