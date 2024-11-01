package io.nosql.app.screen_movie.dto;

import io.nosql.app.screen_movie.domain.Filmes;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record MovieDTO (
        String id,
        @NotNull String title,
        @NotNull Double score,
        @NotNull Integer count,
        @NotNull String image
) implements Serializable {

    public static MovieDTO converterMovieModel(Filmes filmes) {
        return new MovieDTO(
                filmes.getId(),
                filmes.getTitle(),
                filmes.getScore(),
                filmes.getCount(),
                filmes.getImage());
    }

}
