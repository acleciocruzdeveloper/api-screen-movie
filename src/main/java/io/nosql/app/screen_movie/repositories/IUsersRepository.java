package io.nosql.app.screen_movie.repositories;

import io.nosql.app.screen_movie.domain.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IUsersRepository extends MongoRepository<Usuarios, String> {
    Optional<Usuarios> findByEmail(String email);
}
