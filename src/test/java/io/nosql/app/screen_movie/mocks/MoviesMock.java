package io.nosql.app.screen_movie.mocks;

import io.nosql.app.screen_movie.domain.Movie;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MoviesMock {

    public static Movie criateMovie(String mockId, String mockTitle, Double mockScore, Integer mockCount, String mockImage) {
        return new Movie(mockId, mockTitle, mockScore, mockCount, mockImage);
    }

    public static List<Movie> createMovieList() {
        Movie django = Movie.builder()
                .id(UUID.randomUUID().toString())
                .title("Django Livre")
                .score(4.3)
                .count(0)
                .image("alguma imagem")
                .build();

        Movie matrix = Movie.builder()
                .id(UUID.randomUUID().toString())
                .title("Matrix")
                .score(4.3)
                .count(0)
                .image("alguma imagem")
                .build();

        return Arrays.asList(django, matrix);
    }

    public static Movie createDefaultMovie() {
        return Movie.builder()
                .id(UUID.randomUUID().toString())
                .title("Matrix")
                .score(4.3)
                .count(0)
                .image("alguma imagem")
                .build();
    }

}
