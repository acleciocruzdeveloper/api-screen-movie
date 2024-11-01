package io.nosql.app.screen_movie.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenRecord(
        @JsonProperty("access_token") String accessToken,
        String scope,
        Long expiry
) {
}
