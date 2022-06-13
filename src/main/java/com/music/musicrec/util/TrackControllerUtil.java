 package com.music.musicrec.util;

 import com.music.musicrec.domain.TracksEntity;
 import com.music.musicrec.exceptions.MappingException;
 import com.music.musicrec.models.TrackSearchRequest;
 import com.music.musicrec.models.TrackSearchResponse;

 import java.util.Arrays;
 import java.util.List;

 public class TrackControllerUtil {

     private TrackControllerUtil() {
     }

     public static TrackSearchResponse mapToResponse(TrackSearchRequest trackSearchRequest) throws MappingException {
         if (trackSearchRequest == null) {
             throw new MappingException("Error mapping TrackSearchRequest to TrackSearchResponse");
         }

         try {
             return TrackSearchResponse.builder()
                    .id(trackSearchRequest.getId())
                    .name(trackSearchRequest.getName())
                    .popularity(trackSearchRequest.getPopularity())
                    .releaseDate(trackSearchRequest.getReleaseDate())
                    .explicit(trackSearchRequest.getExplicit())
                    .artists(trackSearchRequest.getArtists())
                    .idArtists(trackSearchRequest.getIdArtists())
                    .energy(trackSearchRequest.getEnergy())
                    .danceability(trackSearchRequest.getDanceability())
                    .build();

         } catch (Exception e) {
             throw new MappingException("Error mapping TrackSearchRequest to TrackSearchResponse");

         }
     }

     public static TrackSearchResponse mapToSearchResponse(TracksEntity trackSearch) {

             return TrackSearchResponse.builder()
                    .id(trackSearch.getId())
                    .name(trackSearch.getName())
                    .popularity(trackSearch.getPopularity())
                    .releaseDate(trackSearch.getReleaseDate())
                    .explicit(trackSearch.getExplicit())
                    .artists(trackSearch.getArtists())
                    .idArtists(trackSearch.getIdArtists())
                    .energy(trackSearch.getEnergy())
                    .danceability(trackSearch.getDanceability())
                    .build();

     }
 }
