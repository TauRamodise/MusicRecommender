package com.music.musicrec.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistSearchResponse {

    @ApiModelProperty(value = "id", example = "75")
    private String id;

    @ApiModelProperty(value = "Followers", example = "75")
    private int followers;

    @ApiModelProperty(value = "Genre of Music", example = "RnB")
    private String genre;

    @ApiModelProperty(value = "Name of Artist", example = "Adele")
    private String name;

    @ApiModelProperty(value = "Artist Popularity", example = "75")
    private int popularity;



}
