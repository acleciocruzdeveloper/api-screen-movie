package io.nosql.app.screen_movie.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbRecord(
        @JsonAlias("Title") String title,
        @JsonAlias("Year") String age,
        @JsonAlias("Genre") String genre,
        @JsonAlias("Rated") String rated,
        @JsonAlias("Director") String director,
        @JsonAlias("Plot") String plot,
        @JsonAlias("Poster") String poster,
        @JsonAlias("imdbRating") String imdbRating
) {
}
