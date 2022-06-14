package com.music.musicrec.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Tracks")
@NoArgsConstructor
@Getter
@Setter
public class TracksEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "popularity")
    private int popularity;

    @Column(name = "explicit")
    private int explicit;

    @Column(name = "artists")
    private String artists;

    @Column(name = "id_artists")
    private String artistId;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "danceability")
    private int danceability;

    @Column(name = "energy")
    private int energy;


}
