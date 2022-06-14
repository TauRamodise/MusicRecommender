package com.music.musicrec.controllers;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.models.TrackSearchResponse;
import com.music.musicrec.services.ArtistServiceImpl;
import com.music.musicrec.services.TracksServiceImpl;
import com.music.musicrec.util.TrackControllerUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@NoArgsConstructor
public class SongsByMoodController {

    private ArtistServiceImpl artistService;
    private TracksServiceImpl tracksService;

    @ApiOperation("Search for songs based on your mood")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/get-songs-by-mood", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackSearchResponse>> getSongsByMood() {
        List<TracksEntity> getSongsByMood = tracksService.getSongsByMood();
        //SongsByMoodResponse getSongs = (SongsByMoodResponse) getSongsByMood.stream().map(SongsByMoodControllerUtil::mapToSearchResponse).collect(Collectors.toList());
        TrackSearchResponse getSongs = (TrackSearchResponse) getSongsByMood.stream().map(TrackControllerUtil::mapToSearchResponse).collect(Collectors.toList());
        return ResponseEntity.ok(List.of(getSongs));
    }

}
