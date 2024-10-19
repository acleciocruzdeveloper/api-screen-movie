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
public class Usuarios  {

    @Id
    private final String id;

    private final String nome;

    private final int age;

    private final String password;

    private final String email;

    private final EPerfis perfil;


    public static Usuarios converterUserDomain(UsuariosDTO usuariosDTO){
        return Usuarios.builder()
                .id(usuariosDTO.id())
                .nome(usuariosDTO.nome())
                .password(usuariosDTO.password())
                .age(usuariosDTO.age())
                .email(usuariosDTO.email())
                .perfil(EPerfis.USUARIO)
                .build();
    }

}
