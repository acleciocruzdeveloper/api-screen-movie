package io.nosql.app.screen_movie.services;

import io.nosql.app.screen_movie.domain.UsuariosAutenticados;
import io.nosql.app.screen_movie.repositories.IUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioAutenticadoService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final IUsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .map(UsuariosAutenticados::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado"));
    }
}
