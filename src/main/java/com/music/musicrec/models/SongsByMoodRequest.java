package com.music.musicrec.models;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SongsByMoodRequest {
    @ApiModelProperty(value = "Energy level desired for song selection", example = "35", required = true)
    @NotNull
    @Min(value = 0, message = "Enter a number between 0 and 100")
    @Max(value = 100, message = "Enter a number between 0 and 100")
    private int energy;
}
