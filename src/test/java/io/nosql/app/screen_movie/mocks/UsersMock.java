package io.nosql.app.screen_movie.mocks;

import io.nosql.app.screen_movie.domain.Usuarios;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UsersMock {

    public static Usuarios UsersMock(String id, String nome, int age, String password, String email) {
        return Usuarios.builder()
                .id(id)
                .nome(nome)
                .age(age)
                .password(password)
                .email(email)
                .build();
    }

    public static List<Usuarios> listUsers() {
        Usuarios raul = Usuarios.builder()
                .id(UUID.randomUUID().toString())
                .nome("Raul Seixas")
                .age(45)
                .password("123456")
                .email("raulseixas@email.com")
                .build();
        Usuarios paulo = Usuarios.builder()
                .id(UUID.randomUUID().toString())
                .nome("Paulo Gustavo")
                .age(45)
                .password("123456")
                .email("paulogustavo@email.com")
                .build();

        return Arrays.asList(raul, paulo);
    }

    public static Usuarios createDefaultUser() {
        return Usuarios.builder()
                .id(UUID.randomUUID().toString())
                .nome("Raul Seixas")
                .age(45)
                .password("123456")
                .email("raulseixas@email.com")
                .build();
    }
}
