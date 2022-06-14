package com.music.musicrec.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TrackSearchRequest {

    @ApiModelProperty(value = "ID of Song", example = "0cqRj7pUJDkTCEsJkx8snD")
    private String id;

    @ApiModelProperty(value = "Name of Song", example = "Shake It Off")
    private String name;

    @ApiModelProperty(value = "Popularity", example = "89")
    private Integer popularity;

    @ApiModelProperty(value = "Release date", example = "27-10-2014")
    private Date releaseDate;

    @ApiModelProperty(value = "Explicit", example = "0")
    private Integer explicit;

    @ApiModelProperty(value = "Artists on the Song", example = "['Taylor Swift']")
    private String artists;

    @ApiModelProperty(value = "ID of Artists", example = "['06HL4z0CvFAxyc27GXpf02']")
    private String idArtists;
    
    @ApiModelProperty(value = "Energy", example = "92")
    private Integer energy;
    
    @ApiModelProperty(value = "Danceability", example = "99")
    private Integer danceability;

}

