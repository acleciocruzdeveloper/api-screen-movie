package io.nosql.app.screen_movie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.nosql.app.screen_movie.domain.Usuarios;
import io.nosql.app.screen_movie.dto.UsuariosDTO;
import io.nosql.app.screen_movie.mocks.UsersMock;
import io.nosql.app.screen_movie.services.UserService;
import io.nosql.app.screen_movie.utils.UriComponent;
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
import org.springframework.test.web.servlet.ResultActions;

import java.net.URI;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    UserService userService;

    @MockBean
    UriComponent uriComponent;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("deve retornar uma lista de usuarios cadastrados")
    void deveBuscarUmaListaDeUsuariosNoMongoDB() throws Exception {

        List<Usuarios> usuarios = UsersMock.listUsers();

        when(userService.findAllUser()).thenReturn(usuarios);

        ResultActions result = mvc.perform(get(UriComponent.URI_USERS)
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(usuarios)));

        Mockito.verify(userService, Mockito.times(1)).findAllUser();

    }

    @Test
    @DisplayName("deve realizar o cadastro de um novo usuario com sucesso")
    void deveInserirUmNovoUsuarioComSucessoNoMongoDB() throws Exception {

        Usuarios usuario = UsersMock.createDefaultUser();
        UsuariosDTO usuariosDTO = UsuariosDTO.converterToUserModel(usuario);

        when(userService.cadastrar(any(UsuariosDTO.class))).thenReturn(usuariosDTO);

        when(uriComponent.builderUriWithId(any(String.class), any()))
                .thenReturn(URI.create(UriComponent.URI_USERS + usuario.getId()));

        ResultActions result = mvc.perform(post(UriComponent.URI_CREATE_USERS)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(usuario)));

        result.andExpect(status().isCreated());
    }

}
