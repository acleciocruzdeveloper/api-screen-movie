package io.nosql.app.screen_movie.utils;

import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class UriBuilder {

    public static final String URI_CREATE_USERS = "/collections/create/users";
    public static final String URI_USERS = "/collections/users";
    public static final String URI_REGISTER_MOVIES = "/collections/new/movies";
    public static final String URI_USER_ID = "/collections/users/{id}";
    public static final String URI_MOVIE_ID = "/collections/movies/{id}";
    public static final String URI_MOVIES = "/collections/movies";
    public static final String URI_DELETE_MOVIE = "/collections/movies/{id}";


    public URI builderUriWithId(String uriTemplate, Object id) {
        String uri = uriTemplate.replace("{id}", id.toString());
        return URI.create(uri);
    }

}
