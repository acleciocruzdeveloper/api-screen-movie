package io.nosql.app.screen_movie.utils;

public interface IConverter {

    <T> T convertData(String json, Class<T> classe);

}
