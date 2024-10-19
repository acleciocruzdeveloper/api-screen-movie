package io.nosql.app.screen_movie.controller;

import io.nosql.app.screen_movie.domain.Usuarios;
import io.nosql.app.screen_movie.dto.UsuariosDTO;
import io.nosql.app.screen_movie.services.UserService;
import io.nosql.app.screen_movie.utils.UriComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UsuariosController {

    private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);

    private final UserService userService;

    public UsuariosController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = UriComponent.URI_USERS, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Usuarios>> allUsers() {
        logger.info("FIND ALL USERS DATABASE!!");
        return ResponseEntity.ok().body(userService.findAllUser());
    }

    @RequestMapping(value = UriComponent.URI_USER_ID, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Usuarios> userId(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @RequestMapping(value = UriComponent.URI_CREATE_USERS, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuariosDTO> createUser(@RequestBody UsuariosDTO user) {

        UsuariosDTO usuariosDTO = userService.cadastrar(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(usuariosDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(usuariosDTO);
    }

    @RequestMapping(value = UriComponent.URI_DELETE_USER, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
