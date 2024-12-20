package io.nosql.app.screen_movie.controller;

import io.nosql.app.screen_movie.domain.TokenRecord;
import io.nosql.app.screen_movie.services.AuthService;
import io.nosql.app.screen_movie.utils.UriComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @RequestMapping(value = UriComponent.URI_LOGIN, method = RequestMethod.POST)
    public ResponseEntity<TokenRecord> login(Authentication authentication) {
        try {
            log.info("REQUEST AUTH API");
            TokenRecord autenticar = authService.autenticar(authentication);
            return ResponseEntity.ok().body(autenticar);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).build();
        }
    }
}
