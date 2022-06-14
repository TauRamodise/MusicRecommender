package com.music.musicrec.controllers;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.ArtistSearchResponse;
import com.music.musicrec.services.ArtistServiceImpl;
import com.music.musicrec.util.SearchControllerUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
public class ArtistController {

    private ArtistServiceImpl artistService;

    @Autowired
    public ArtistController(ArtistServiceImpl artistService) {
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

    @ApiOperation("Search for one Artist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/search-all-artist/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtistSearchResponse> getOneArtists(@PathVariable String id) {

        return ResponseEntity.ok(mapToSearchResponseExample());
    }

    @ApiOperation("Search for Similar Artists")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/find-similar-artists/{artistName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistSearchResponse>> findSimilarArtists(@PathVariable String artistName) throws Exception {
        try
        {
            List<ArtistsEntity> getAllArtists = artistService.findSimilarArtists(artistName);
            List<ArtistSearchResponse> getAll = getAllArtists.stream().map(SearchControllerUtil::mapToSearchResponse).collect(Collectors.toList());
            return ResponseEntity.ok(getAll);
        } catch (MappingException e) {
            throw new MappingException("We could not find any similar artists", e.getCause());
        }
    }
    @ApiOperation("Search for Top Artists in Genre")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/search-artists-by-genre/{genre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistSearchResponse>> getArtistsByGenre(@ApiParam(value="Choose a genre, eg. Pop", required = true) @PathVariable("genre") String genre) throws MappingException {
        try {
            List<ArtistsEntity> getArtistsByGenre = artistService.getArtistsByGenre(genre);
            List<ArtistSearchResponse> top10 = getArtistsByGenre.stream().map(SearchControllerUtil::mapToSearchResponse).collect(Collectors.toList());
            return ResponseEntity.ok(top10);
        } catch (MappingException e) {
            throw new MappingException("That genre was not found in the database.", e.getCause());
        }
    }


}
