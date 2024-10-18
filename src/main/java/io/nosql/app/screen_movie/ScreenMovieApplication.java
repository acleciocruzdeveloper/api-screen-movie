package io.nosql.app.screen_movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ScreenMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScreenMovieApplication.class, args);
    }

}
