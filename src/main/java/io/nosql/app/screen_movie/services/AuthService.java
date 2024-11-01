package io.nosql.app.screen_movie.services;

import io.nosql.app.screen_movie.domain.TokenRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;

    public TokenRecord autenticar(Authentication authentication) {
        log.info("require authenticate");
        return jwtService.getToken(authentication);
    }
}
