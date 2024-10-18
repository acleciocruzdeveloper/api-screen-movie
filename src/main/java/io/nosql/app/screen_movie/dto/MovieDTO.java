package io.nosql.app.screen_movie.dto;

import io.nosql.app.screen_movie.domain.Movie;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record MovieDTO (
        String id,
        @NotNull String title,
        @NotNull Double score,
        @NotNull Integer count,
        @NotNull String image
) implements Serializable {

    public static MovieDTO converterMovieModel(Movie movie) {
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getScore(),
                movie.getCount(),
                movie.getImage());
    }

}
