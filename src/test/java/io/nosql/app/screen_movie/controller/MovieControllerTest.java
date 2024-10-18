package io.nosql.app.screen_movie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.nosql.app.screen_movie.domain.Movie;
import io.nosql.app.screen_movie.dto.MovieDTO;
import io.nosql.app.screen_movie.mocks.MoviesMock;
import io.nosql.app.screen_movie.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MovieService movieService;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("deve registrar um filme com sucesso no mongodb")
    void deveInserirUmFilmeComSucessoNoMongoDB() throws Exception {
        Movie movie = MoviesMock.createDefaultMovie();
        MovieDTO movieDTO = MovieDTO.converterMovieModel(movie);

        mvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(movieDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("nao deve registrar um filme com body invalido")
    void deveRetornarBadRequestComRequisicaoSemParametrosObrigatorios() throws Exception {

        MovieDTO invalidMovieDTO = new MovieDTO(UUID.randomUUID().toString(), null, 2.0,1,  "alguma imagem");

        mvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidMovieDTO)))
                .andExpect(status().isBadRequest());

        verify(movieService, Mockito.never()).movieRegistry(any(MovieDTO.class));
    }
}
