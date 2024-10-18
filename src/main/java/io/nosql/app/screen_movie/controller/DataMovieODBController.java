package io.nosql.app.screen_movie.controller;

import io.nosql.app.screen_movie.config.OmdbConfig;
import io.nosql.app.screen_movie.map.OmdbMapper;
import io.nosql.app.screen_movie.model.OmdbRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DataMovieODBController {

    private final OmdbConfig omdbConfig;

    private final OmdbMapper mapper;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @RequestMapping(value = "/dataMovie", method = RequestMethod.GET)
    public ResponseEntity<OmdbRecord> getDataMove(@RequestParam String imdbId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?t=%s&apikey=%s", omdbConfig.getBaseUrl(), imdbId, omdbConfig.getApikey());

        ResponseEntity<String> responseEntity = (restTemplate.getForEntity(url, String.class));

        log.info("RESPONSE OMDB::: {}", responseEntity);

        OmdbRecord omdbRecord = mapper.obterDados(responseEntity.getBody(), OmdbRecord.class);
        return ResponseEntity.ok().body(omdbRecord);
    }
}
