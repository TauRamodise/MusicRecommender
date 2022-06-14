package com.music.musicrec.controllers;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.models.ArtistEssentialsResponse;
import com.music.musicrec.services.TracksServiceImpl;
import com.music.musicrec.util.ArtistEssentialsControllerUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ArtistEssentialsController {

    private TracksServiceImpl tracksService;

    @Autowired
    public ArtistEssentialsController(TracksServiceImpl tracksService) {
        this.tracksService = tracksService;
    }

    @ApiOperation("Get an Artist's Esential Tracks")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/essentials/{artistName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistEssentialsResponse>> getArtistEssentials(@PathVariable String artistName, @RequestParam("count") Optional<Integer> count) {
        List<TracksEntity> getArtistEsentials = tracksService.getArtistEssentials(artistName, count.orElse(20).intValue());
        List<ArtistEssentialsResponse> result = getArtistEsentials.stream().map(ArtistEssentialsControllerUtil::mapToArtistEssentialsResponse).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

}
