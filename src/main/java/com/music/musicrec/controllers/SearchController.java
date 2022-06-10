package com.music.musicrec.controllers;

import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.ArtistSearchRequest;
import com.music.musicrec.models.ArtistSearchResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.music.musicrec.util.SearchControllerUtil.mapToResponse;

@RestController
public class SearchController {

    @ApiOperation("Search for Simillar Artists")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/search-artist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistSearchResponse>> searchSimilarArtists(ArtistSearchRequest artistSearchRequest) throws MappingException {
        return ResponseEntity.ok(List.of(mapToResponse(artistSearchRequest)));
    }
}
