package com.music.musicrec.controllers;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.models.TrackSearchResponse;
import com.music.musicrec.services.TracksServiceImpl;
import com.music.musicrec.util.TrackControllerUtil;
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


@RestController

public class SongsByMoodController {


    private TracksServiceImpl tracksService;

    @Autowired
    public SongsByMoodController(TracksServiceImpl tracksService){this.tracksService=tracksService;}

    @ApiOperation("Search for songs based on your mood")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/get-songs-by-mood/{energy}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackSearchResponse>> getSongsByMood(@PathVariable int energy) {
        List<TracksEntity> getSongsByMood = tracksService.getSongsByMood(energy);
        List<TrackSearchResponse> getSongs =  getSongsByMood.stream().map(TrackControllerUtil::mapToSearchResponse).collect(Collectors.toList());
        return ResponseEntity.ok(getSongs);
    }

}
