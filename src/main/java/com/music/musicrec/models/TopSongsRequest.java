package com.music.musicrec.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class TopSongsRequest {

    @ApiModelProperty(value = "Year for top songs", example = "1989", required = true)
    @NotNull(message = "Tell us the year")
    @Pattern(regexp = "^(19|20)\\d{2}$", message="Invalid year supplied")
    private String year;

}

