package io.nosql.app.screen_movie.domain;

import io.nosql.app.screen_movie.dto.ScoreDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "score")
public class Score implements Serializable {

    @Serial
    private static final long serialVersionUID = 7904403692827509702L;

    @Id
    private String id;

    private Double value;

    @DBRef
    private Movie movie;

    @DBRef
    private Usuarios usuarios;


    public static Score converterScoreDomain(ScoreDTO scoreDTO) {
        return Score.builder()
                .id(scoreDTO.id())
                .value(scoreDTO.value())
                .movie(Movie.converterToMovieDomain(scoreDTO.movieDTO()))
                .usuarios(Usuarios.converterUserDomain(scoreDTO.usuariosDTO()))
                .build();
    }
}
