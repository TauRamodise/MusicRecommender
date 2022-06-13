package com.music.musicrec.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ArtistSearchResponse {

    @ApiModelProperty(value = "Name of Artist", example = "Adele")
    private String artistName;

    @ApiModelProperty(value = "Genre of Music", example = "RnB")
    private String genre;

    @ApiModelProperty(value = "Artist Popularity", example = "75")
    private int popularity;

}
