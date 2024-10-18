package io.nosql.app.screen_movie.dto;

import io.nosql.app.screen_movie.domain.Usuarios;

public record UsuariosDTO(String id, String nome, int age, String password, String email) {

    public static UsuariosDTO converterToUserModel(Usuarios user) {
        return new UsuariosDTO(user.getId(), user.getNome(), user.getAge(), user.getPassword(), user.getEmail());
    }
}
