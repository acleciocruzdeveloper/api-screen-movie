//package io.nosql.app.screen_movie.infra;
//
//import io.nosql.app.screen_movie.controller.UserController;
//import io.nosql.app.screen_movie.domain.Usuarios;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.RepresentationModelAssembler;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserModelAssembler implements RepresentationModelAssembler<Usuarios, EntityModel<Usuarios>> {
//
//    @Override
//    public EntityModel<Usuarios> toModel(Usuarios users) {
//        return EntityModel.of(users,
//                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class)
//                        .userId(users.getId())).withSelfRel());
//    }
//}
