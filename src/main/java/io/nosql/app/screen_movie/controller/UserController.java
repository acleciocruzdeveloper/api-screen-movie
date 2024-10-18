package io.nosql.app.screen_movie.controller;

import io.nosql.app.screen_movie.domain.Usuarios;
import io.nosql.app.screen_movie.infra.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Usuarios>> allUsers() {
        logger.info("FIND ALL USERS DATABASE!!");
        return ResponseEntity.ok().body(userService.findAllUser());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Usuarios> userId(@PathVariable String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<Usuarios> createUser(@RequestBody Usuarios user) {
        Usuarios entity = userService.cadastrar(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
