package com.music.musicrec.controllers;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.*;
import com.music.musicrec.services.TracksServiceImpl;
import com.music.musicrec.util.ArtistEssentialsControllerUtil;
import com.music.musicrec.util.TrackControllerUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TracksController
{
    private TracksServiceImpl tracksService;
    @Autowired
    public TracksController(TracksServiceImpl tracksService){this.tracksService=tracksService;}

    @ApiOperation("Search for songs based on your mood")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/get-songs-by-mood", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackSearchResponse>> getSongsByMood(@Valid SongsByMoodRequest songsByMoodRequest) throws MappingException {
        List<TracksEntity> getSongsByMood = tracksService.getSongsByMood(songsByMoodRequest.getMood());
        List<TrackSearchResponse> getSongs =  getSongsByMood.stream().map(TrackControllerUtil::mapToSearchResponse).collect(Collectors.toList());
        return ResponseEntity.ok(getSongs);
    }

    @ApiOperation("Get Top 50 Songs For A Given Year")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/get-top-songs", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<TrackSearchResponse>> getTopSongs(@Valid TopSongsRequest topSongsRequest) throws Exception {
        try {
            List<TracksEntity> getTopSongs = tracksService.getTopSongs(topSongsRequest.getYear());
            List<TrackSearchResponse> getAll = getTopSongs.stream().map(TrackControllerUtil::mapToSearchResponse).collect(Collectors.toList());
            return ResponseEntity.ok(getAll);
        }
        catch (Exception e) {
            throw new MappingException("No records found for given year", e.getCause());
        }
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

