package io.nosql.app.screen_movie.dto;

public record ScoreDTO(
        String id, Double value, MovieDTO movieDTO, UsuariosDTO usuariosDTO
) {
    public static ScoreDTO converterToScoreModel(MovieDTO movieDTO, UsuariosDTO usuariosDTO) {
        return new ScoreDTO("", 0.0, movieDTO, usuariosDTO);
    }
}
