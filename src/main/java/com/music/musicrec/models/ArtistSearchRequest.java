package com.music.musicrec.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArtistSearchRequest {

    @ApiModelProperty(value = "Name of Artist", example = "Adele")
    private String artistName;

    @ApiModelProperty(value = "Genre of Music", example = "RnB")
    private String genre;

    @ApiModelProperty(value = "Release date", example = "2019")
    private Date releaseYear;

}
