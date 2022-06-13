package com.music.musicrec.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongsByMoodResponse {

    @ApiModelProperty(value = "Name of Songs", example = "Happy")
    private String name;

    @ApiModelProperty(value = "Name of Artist", example = "Pharrell Williams")
    private String artists;

    @ApiModelProperty(value = "Energy level", example = "75")
    private int energy;
}
