package io.nosql.app.screen_movie.domain;

import io.nosql.app.screen_movie.dto.UsuariosDTO;
import io.nosql.app.screen_movie.enums.EPerfis;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document(collection = "usuarios")
public class Usuarios {

    @Id
    private String id;

    private String nome;

    private int age;

    private String password;

    private String email;

    private EPerfis perfil;


    public static Usuarios converterUserDomain(UsuariosDTO usuariosDTO) {
        return Usuarios.builder()
                .id(usuariosDTO.getId())
                .nome(usuariosDTO.getNome())
                .password(usuariosDTO.getPassword())
                .age(usuariosDTO.getAge())
                .email(usuariosDTO.getEmail())
                .perfil(EPerfis.CUSTOMERS)
                .build();
    }

}
