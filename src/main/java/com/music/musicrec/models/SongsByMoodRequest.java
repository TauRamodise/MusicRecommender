package com.music.musicrec.models;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SongsByMoodRequest {
    @ApiModelProperty(value = "Choose a mood: Chill, Vibey, Party", example = "Chill", required = true)
    @NotNull
    private String mood;
}
