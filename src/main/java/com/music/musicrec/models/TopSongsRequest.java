package com.music.musicrec.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class TopSongsRequest {

    @ApiModelProperty(value = "Year for top songs", example = "1989", required = true)
    @NotNull
    @Pattern(regexp = "^(19|20)\\d{2}$", message="Invalid year")
    private String year;

}

