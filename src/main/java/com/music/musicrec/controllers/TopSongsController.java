package com.music.musicrec.controllers;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.ArtistSearchRequest;
import com.music.musicrec.models.TrackSearchResponse;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.music.musicrec.util.SearchControllerUtil.mapToSearchResponse;


@RestController
@AllArgsConstructor
@NoArgsConstructor
public class TopSongsController {

    private TracksServiceImpl tracksService;

    @ApiOperation("Get Top 50 Songs For A Given Year")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation"),
            @ApiResponse(code = 400, message = "Invalid Request"),
            @ApiResponse(code = 500, message = "Unknown Error Occurred")
    })
    @GetMapping(value = "/get-top-songs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackSearchResponse>> getTopSongs() {
        List<TracksEntity> getTopSongs = tracksService.getTopSongs();
        TrackSearchResponse getAll = (TrackSearchResponse) getTopSongs.stream().map(TrackControllerUtil::mapToSearchResponse).collect(Collectors.toList());
        return ResponseEntity.ok(List.of(getAll));
    }

}
