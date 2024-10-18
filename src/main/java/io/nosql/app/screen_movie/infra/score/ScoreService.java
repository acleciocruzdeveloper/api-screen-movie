package io.nosql.app.screen_movie.infra.score;

import io.nosql.app.screen_movie.domain.Movie;
import io.nosql.app.screen_movie.domain.Score;
import io.nosql.app.screen_movie.domain.Usuarios;
import io.nosql.app.screen_movie.model.MovieDTO;
import io.nosql.app.screen_movie.model.ScoreDTO;
import io.nosql.app.screen_movie.model.UsuariosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public ScoreDTO registerScoreMovie(ScoreDTO scoreDTO, MovieDTO movie, UsuariosDTO user) {

        Score score = Score.builder()
                .id(scoreDTO.id())
                .value(scoreDTO.value())
                .movie(Movie.converterToMovieDomain(movie))
                .usuarios(Usuarios.converterUserDomain(user))
                .build();

        Score scoreSaved = scoreRepository.save(score);

        return ScoreDTO.converterToScoreModel(movie, user);


    }
}
