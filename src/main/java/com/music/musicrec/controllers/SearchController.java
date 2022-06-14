package com.music.musicrec.controllers;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.ArtistSearchResponse;
import com.music.musicrec.services.ArtistServiceImpl;
import com.music.musicrec.util.SearchControllerUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.music.musicrec.util.SearchControllerUtil.mapToSearchResponseExample;


@RestController
public class SearchController {

    private final ArtistServiceImpl artistService;

    @Autowired
    public SearchController(ArtistServiceImpl artistService) {
        this.artistService = artistService;
    }

    @ApiOperation("Search for Simillar Artists")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/search-all-artist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistSearchResponse>> getAllArtists() {
        List<ArtistsEntity> getAllArtists = artistService.getAllArtists();
        List<ArtistSearchResponse> getAll = getAllArtists.stream().map(SearchControllerUtil::mapToSearchResponse).collect(Collectors.toList());
        return ResponseEntity.ok(getAll);
    }

    @ApiOperation("Search for Simillar Artists")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/search-all-artist/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtistSearchResponse> getOneArtists(@PathVariable String id) {

        return ResponseEntity.ok(mapToSearchResponseExample());
    }

    @ApiOperation("Search for Top Artists in Genre")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/get-artists-by-genre/{genre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistSearchResponse>> getArtistsByGenre(@PathVariable String genre) throws MappingException {
        try {
            List<ArtistsEntity> getArtistsByGenre = artistService.getArtistsByGenre(genre);
            List<ArtistSearchResponse> top10 = getArtistsByGenre.stream().map(SearchControllerUtil::mapToSearchResponse).collect(Collectors.toList());
            return ResponseEntity.ok(top10);
        } catch (MappingException e) {
            throw new MappingException("That genre was not found in the database.", e.getCause());
        }
    }
}
