package io.nosql.app.screen_movie.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "omdb")
public class OmdbConfig {

    private String apikey;
    private String baseUrl;

}
