package io.nosql.app.screen_movie.controller;

import io.nosql.app.screen_movie.services.ScoreService;
import io.nosql.app.screen_movie.dto.MovieDTO;
import io.nosql.app.screen_movie.dto.ScoreDTO;
import io.nosql.app.screen_movie.dto.UsuariosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @RequestMapping(value = "/scores", method = RequestMethod.PUT)
    ScoreDTO saveScore(@RequestBody ScoreDTO scoreDTO, MovieDTO movie, UsuariosDTO user) {
        return scoreService.registerScoreMovie(scoreDTO, movie, user);
    }
}
