package com.music.musicrec.controllers;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.models.ArtistSearchResponse;
import com.music.musicrec.services.ArtistServiceImpl;
import com.music.musicrec.util.SearchControllerUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GetGenreController {
    @Autowired
    private ArtistServiceImpl artistService;

    @Autowired
    public GetGenreController(ArtistServiceImpl artistService) {
        this.artistService = artistService;
    }

    @ApiOperation("Get a list of all genres")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/all-genres", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllGenres() {
        List<String> allGenres = artistService.getGenres();

        return ResponseEntity.ok(allGenres);
    }

}