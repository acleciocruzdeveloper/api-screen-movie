package io.nosql.app.screen_movie.services;

import io.nosql.app.screen_movie.domain.Filmes;
import io.nosql.app.screen_movie.domain.Score;
import io.nosql.app.screen_movie.domain.Usuarios;
import io.nosql.app.screen_movie.dto.MovieDTO;
import io.nosql.app.screen_movie.dto.ScoreDTO;
import io.nosql.app.screen_movie.dto.UsuariosDTO;
import io.nosql.app.screen_movie.repositories.ScoreRepository;
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
                .filmes(Filmes.converterToMovieDomain(movie))
                .usuarios(Usuarios.converterUserDomain(user))
                .build();

        Score scoreSaved = scoreRepository.save(score);

        return ScoreDTO.converterToScoreModel(movie, user);


    }
}
