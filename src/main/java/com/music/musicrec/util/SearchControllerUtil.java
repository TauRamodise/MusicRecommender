 package com.music.musicrec.util;

 import com.music.musicrec.domain.ArtistsEntity;
 import com.music.musicrec.exceptions.MappingException;
 import com.music.musicrec.models.ArtistSearchRequest;
 import com.music.musicrec.models.ArtistSearchResponse;

 import java.util.Arrays;
 import java.util.List;

 public class SearchControllerUtil {

     private SearchControllerUtil() {
     }

     public static ArtistSearchResponse mapToResponse(ArtistSearchRequest artistSearchRequest) throws MappingException {
         if (artistSearchRequest == null) {
             throw new MappingException("Error mapping ArtistSearchRequest to ArtistSearchResponse");
         }

         try {
             return ArtistSearchResponse.builder()
                     .artistName(artistSearchRequest.getArtistName())
                     .genre(artistSearchRequest.getGenre())
                     .build();

         } catch (Exception e) {
             throw new MappingException("Error mapping ArtistSearchRequest to ArtistSearchResponse");

         }
     }

     public static ArtistSearchResponse mapToSearchResponse(ArtistsEntity artistSearch) {

             return ArtistSearchResponse.builder()
                     .artistName(artistSearch.getName())
                     .genre(artistSearch.getGenres())
                     .popularity(artistSearch.getPopularity())
                     .build();

     }
 }
