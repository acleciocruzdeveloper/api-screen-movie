package io.nosql.app.screen_movie.mocks;

import io.nosql.app.screen_movie.domain.Filmes;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MoviesMock {

    public static Filmes criateMovie(String mockId, String mockTitle, Double mockScore, Integer mockCount, String mockImage) {
        return new Filmes(mockId, mockTitle, mockScore, mockCount, mockImage);
    }

    public static List<Filmes> createMovieList() {
        Filmes django = Filmes.builder()
                .id(UUID.randomUUID().toString())
                .title("Django Livre")
                .score(4.3)
                .count(0)
                .image("alguma imagem")
                .build();

        Filmes matrix = Filmes.builder()
                .id(UUID.randomUUID().toString())
                .title("Matrix")
                .score(4.3)
                .count(0)
                .image("alguma imagem")
                .build();

        return Arrays.asList(django, matrix);
    }

    public static Filmes createDefaultMovie() {
        return Filmes.builder()
                .id(UUID.randomUUID().toString())
                .title("Matrix")
                .score(4.3)
                .count(0)
                .image("alguma imagem")
                .build();
    }

}
