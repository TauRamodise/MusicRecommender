package com.music.musicrec.controllers;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.ArtistSearchRequest;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.music.musicrec.util.SearchControllerUtil.mapToSearchResponse;


@RestController
public class SimilarArtistsController {
    @Autowired
    private ArtistServiceImpl artistService;

    @Autowired
    public SimilarArtistsController(ArtistServiceImpl artistService) {
        this.artistService = artistService;
    }

    @ApiOperation("Search for Similar Artists")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/find-similar-artists/{artistName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistSearchResponse>> findSimilarArtists(@PathVariable String artistName) throws Exception {
        try {
            List<ArtistsEntity> getAllArtists = artistService.findSimilarArtists(artistName);
            List<ArtistSearchResponse> getAll = getAllArtists.stream().map(SearchControllerUtil::mapToSearchResponse).collect(Collectors.toList());
            return ResponseEntity.ok(getAll);
        } catch (MappingException e) {
            throw new MappingException("We could not find any similar artists", e.getCause());
        }
    }
}
