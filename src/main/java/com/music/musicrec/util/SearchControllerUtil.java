package com.music.musicrec.util;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.models.ArtistSearchResponse;

public class SearchControllerUtil {

    private SearchControllerUtil() {
    }

    public static ArtistSearchResponse mapToSearchResponseExample() {

        return ArtistSearchResponse.builder()
                .id("00FQb4jTyendYWaN8pK0wa")
                .name("Lana Del Rey")
                .genre("pop")
                .popularity(89)
                .followers(12750166)
                .build();

    }

    public static ArtistSearchResponse mapToSearchResponse(ArtistsEntity artistSearch) {

        return ArtistSearchResponse.builder()
                .id("00FQb4jTyendYWaN8pK0wa")
                .name("Lana Del Rey")
                .genre("pop")
                .popularity(89)
                .followers(12750166)
                .build();

    }
}
