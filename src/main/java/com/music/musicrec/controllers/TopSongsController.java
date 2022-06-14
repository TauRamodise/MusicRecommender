package com.music.musicrec.controllers;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.exceptions.RecordNotFoundException;
import com.music.musicrec.models.TopSongsRequest;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class TopSongsController {

    private TracksServiceImpl tracksService;
    @Autowired
    public TopSongsController(TracksServiceImpl tracksService) {
        this.tracksService = tracksService;
    }

    @ApiOperation("Get Top 50 Songs For A Given Year")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/get-top-songs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackSearchResponse>> getTopSongs(@Valid TopSongsRequest topSongsRequest) throws Exception {
        try {
            List<TracksEntity> getTopSongs = tracksService.getTopSongs(topSongsRequest.getYear());
            List<TrackSearchResponse> getAll = getTopSongs.stream().map(TrackControllerUtil::mapToSearchResponse).collect(Collectors.toList());
            return ResponseEntity.ok(getAll);
        }
        catch (Exception e) {
            throw new RecordNotFoundException("No records found for given year");
        }
    }

}
