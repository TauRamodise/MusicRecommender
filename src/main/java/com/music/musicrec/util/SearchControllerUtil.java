package com.music.musicrec.util;

import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.ArtistSearchRequest;
import com.music.musicrec.models.ArtistSearchResponse;

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
                    .releaseYear(artistSearchRequest.getReleaseYear())
                    .build();

        } catch (Exception e) {
            throw new MappingException("Error mapping ArtistSearchRequest to ArtistSearchResponse");

        }
    }
}
