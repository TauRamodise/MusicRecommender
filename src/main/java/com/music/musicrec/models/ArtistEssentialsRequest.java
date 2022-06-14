package com.music.musicrec.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ArtistEssentialsRequest {

    @ApiModelProperty(value = "Name of Artist", example = "Adele", required = true)
    private String artistName;

    @ApiModelProperty(value = "Number of Essentials", example = "20", required = false)
    private int count;

}
