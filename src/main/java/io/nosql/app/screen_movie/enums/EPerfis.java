package io.nosql.app.screen_movie.enums;

import lombok.Getter;

@Getter
public enum EPerfis {

    ADMIN("Admin"), USUARIO("Usuario");

    private final String perfil;

    EPerfis(String perfil) {
        this.perfil = perfil;
    }

}
