package com.music.musicrec.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HomeController {

    @Value("${music-rec.redirect.url:}")
    private String redirectURL;

    @RequestMapping(value = "/")
    public String index() {
        return redirectURL;
    }

}