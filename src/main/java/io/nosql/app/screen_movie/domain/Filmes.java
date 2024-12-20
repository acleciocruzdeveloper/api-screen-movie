package io.nosql.app.screen_movie.domain;

import io.nosql.app.screen_movie.dto.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "movies")
public class Filmes implements Serializable {

    @Serial
    private static final long serialVersionUID = 7625529148659077339L;
    @Id
    private String id;
    private String title;
    private Double score;
    private Integer count;
    private String image;


    public static Filmes converterToMovieDomain(MovieDTO movieDTO) {
        return Filmes.builder()
                .id(movieDTO.id())
                .title(movieDTO.title())
                .score(movieDTO.score())
                .count(movieDTO.count())
                .image(movieDTO.image())
                .build();
    }

}
