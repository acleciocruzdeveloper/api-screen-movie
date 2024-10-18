//package io.nosql.app.screen_movie.infra;
//
//import io.nosql.app.screen_movie.controller.MovieController;
//import io.nosql.app.screen_movie.domain.Movie;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.RepresentationModelAssembler;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MovieModelAssembler implements RepresentationModelAssembler<Movie, EntityModel<Movie>> {
//    @Override
//    public EntityModel<Movie> toModel(Movie entity) {
//        return EntityModel.of(entity,
//                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MovieController.class)
//                        .getMovieById(entity.getId())).withSelfRel());
//    }
//}
