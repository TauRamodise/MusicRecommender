package com.music.musicrec.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Artists")
@NoArgsConstructor
@Getter
@Setter
public class ArtistsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "followers")
    private int followers;

    @Column(name = "genres")
    private String genres;

    @Column(name = "name")
    private String name;

    @Column(name = "popularity")
    private int popularity;

}
