package io.nosql.app.screen_movie.dto;

import io.nosql.app.screen_movie.domain.Usuarios;
import io.nosql.app.screen_movie.enums.EPerfis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class UsuariosDTO {

    private String id;
    private String nome;
    private int age;
    private String password;
    private String email;
    private EPerfis perfil;

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
