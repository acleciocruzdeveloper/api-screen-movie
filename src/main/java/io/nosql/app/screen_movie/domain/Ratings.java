package io.nosql.app.screen_movie.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ratings {

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String value;


}
