package io.nosql.app.screen_movie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.nosql.app.screen_movie.domain.Filmes;
import io.nosql.app.screen_movie.dto.MovieDTO;
import io.nosql.app.screen_movie.mocks.MoviesMock;
import io.nosql.app.screen_movie.services.MovieService;
import io.nosql.app.screen_movie.utils.UriComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(FilmesController.class)
public class FilmesControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    MovieService movieService;

    @MockBean
    UriComponent uriComponent;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    WebApplicationContext context;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    @Test
    @WithMockUser(username = "usuario", password = "123456")
    @DisplayName("deve retornar uma lista dos filmes cadastrados")
    void retornaUmaListaDeFilmesComSucesso() throws Exception {
        List<Filmes> movieList = MoviesMock.createMovieList();
        when(movieService.findAllMovies()).thenReturn(movieList);

        mvc.perform(get(UriComponent.URI_MOVIES)
                        .content(String.valueOf(MediaType.APPLICATION_JSON))
                        .header("Authorization", "9d870fs9d87fs09")
                        .content(mapper.writeValueAsString(movieList)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "usuario", password = "123456", roles = {"ADMIN"})
    @DisplayName("nao deve registrar um filme sem autorizacao com token invalido")
    void deveInserirUmFilmeComSucessoNoMongoDB() throws Exception {
        Filmes filmes = MoviesMock.createDefaultMovie();
        MovieDTO movieDTO = MovieDTO.converterMovieModel(filmes);

        when(movieService.movieRegistry(any(MovieDTO.class))).thenReturn(movieDTO);
        when(uriComponent.builderUriWithId(any(String.class), any()))
                .thenReturn(URI.create(UriComponent.URI_MOVIES + movieDTO.id()));

        mvc.perform(post(UriComponent.URI_REGISTER_MOVIES)
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .header("Authorization", "098sfs0d98f7sfd0f98")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(movieDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "usuario", password = "123456", roles = {"ADMIN"})
    @DisplayName("nao deve registrar um filme com body invalido")
    void deveRetornarBadRequestComRequisicaoSemParametrosObrigatorios() throws Exception {

        MovieDTO invalidMovieDTO = new MovieDTO(UUID.randomUUID()
                .toString(), null, 2.0, 1, "alguma imagem");

        mvc.perform(post(UriComponent.URI_REGISTER_MOVIES)
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .content(mapper.writeValueAsString(invalidMovieDTO)))
                .andExpect(status().isBadRequest());

        verify(movieService, Mockito.never()).movieRegistry(any(MovieDTO.class));
    }
}
