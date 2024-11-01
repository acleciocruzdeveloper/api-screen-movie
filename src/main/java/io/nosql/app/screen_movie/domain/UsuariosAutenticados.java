package io.nosql.app.screen_movie.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

public class UsuariosAutenticados implements UserDetails {


    @Serial
    private static final long serialVersionUID = -2577333505816590367L;

    private final Usuarios usuarios;

    public UsuariosAutenticados(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
    }

    @Override
    public String getPassword() {
        return usuarios.getPassword();
    }

    @Override
    public String getUsername() {
        return usuarios.getEmail();
    }
}
