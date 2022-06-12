package com.music.musicrec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class MusicRecApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicRecApplication.class, args);
    }

}
