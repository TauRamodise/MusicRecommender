 package com.music.musicrec.util;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.ArtistEssentialsResponse;

 import java.util.Arrays;
import java.util.Date;
import java.util.List;

 public class ArtistEssentialsControllerUtil {

     public static ArtistEssentialsResponse mapToArtistEssentialsResponse(TracksEntity artistEssentials) {

             return ArtistEssentialsResponse.builder()
                     .popularity(artistEssentials.getPopularity())
                     .name(artistEssentials.getName())
                     .explicit(artistEssentials.getExplicit())
                     .artists(artistEssentials.getArtists())
                     .releaseDate(artistEssentials.getReleaseDate())
                     .danceability(artistEssentials.getDanceability())
                     .energy(artistEssentials.getEnergy())
                     .build();

     }
 }