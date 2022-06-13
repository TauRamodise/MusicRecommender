package com.music.musicrec.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Artists")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArtistsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "followers")
    private int followers;

    @Column(name = "genres")
    private String genres;

    @Column(name = "name")
    private String name;

    @Column(name = "popularity")
    private int popularity;

}
