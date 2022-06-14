package com.music.musicrec.models;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class GenreSearchResponse {
    @ApiModelProperty(value = "Genres", example = "RnB, Hip hop")
    private List<String> genres;
}
