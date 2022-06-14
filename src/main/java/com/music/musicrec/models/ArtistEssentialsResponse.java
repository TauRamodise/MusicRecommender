package com.music.musicrec.models;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistEssentialsResponse {

    @ApiModelProperty(value = "Track Popularity", example = "75")
    private int popularity;

    @ApiModelProperty(value = "Name of Track", example = "Hey Jude")
    private String name;

    @ApiModelProperty(value = "Explicit", example = "1")
    private int explicit;

    @ApiModelProperty(value = "Track Artists", example = "Emminem feat. Taylor Swift")
    private String artists;

    @ApiModelProperty(value = "Release Date", example = "13/12/1993")
    private Date releaseDate;

    @ApiModelProperty(value = "Danceability", example = "5")
    private int danceability;

    @ApiModelProperty(value = "Energy", example = "10")
    private int energy;
}
