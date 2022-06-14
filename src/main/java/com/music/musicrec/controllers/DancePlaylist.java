package com.music.musicrec.controllers;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.Danceability;
import com.music.musicrec.services.TracksServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DancePlaylist {
    private TracksServiceImpl tracksService;

    @Autowired
    public DancePlaylist(TracksServiceImpl tracksService) {
        this.tracksService = tracksService;
    }

    @ApiOperation("Create a playlist by danceability levels")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })

    @PostMapping(value = "/dance-playlist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TracksEntity>> createDanceabilityPlaylist(@RequestBody Danceability danceability) {

        List<TracksEntity> danceabilityPlaylist = null;
        String score = danceability.getDanceability();
        try {
            danceabilityPlaylist = tracksService.getDanceabilityPlaylist(score);
        } catch (MappingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(danceabilityPlaylist);
    }
}
