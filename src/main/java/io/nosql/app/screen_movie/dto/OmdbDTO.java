package io.nosql.app.screen_movie.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6873489881147070753L;
    @JsonAlias("Title")
    private String Title;

    @JsonAlias("Year")
    private String year;

    @JsonAlias("Genre")
    private String genre;
}
