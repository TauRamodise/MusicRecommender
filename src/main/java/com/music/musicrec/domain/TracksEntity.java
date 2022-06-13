package com.music.musicrec.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Artists")
@NoArgsConstructor
@Getter
@Setter
public class TracksEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String trackName;

    @Column(name = "popularity")
    private int popularity;

    @Column(name = "explicit")
    private int explicit;

    @Column(name = "artists")
    private int artists;

    @Column(name = "id_artist")
    private String artistId;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "danceability")
    private int danceability;

    @Column(name = "energy")
    private int energy;


}
