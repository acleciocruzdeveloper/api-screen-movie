package io.nosql.app.screen_movie.utils;

public interface IConverter {

    <T> T obterDados(String json, Class<T> classe);

}
