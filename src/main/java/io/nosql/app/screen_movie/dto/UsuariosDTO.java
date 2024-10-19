package io.nosql.app.screen_movie.dto;

import io.nosql.app.screen_movie.domain.Usuarios;
import io.nosql.app.screen_movie.enums.EPerfis;

public record UsuariosDTO(
        String id,
        String nome,
        int age,
        String password,
        String email,
        EPerfis perfil
) {

    public static UsuariosDTO converterToUserModel(Usuarios user) {
        return new UsuariosDTO(
                user.getId(),
                user.getNome(),
                user.getAge(),
                user.getPassword(),
                user.getEmail(),
                user.getPerfil());
    }
}
