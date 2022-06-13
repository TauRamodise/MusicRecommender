package com.music.musicrec.util;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.SongsByMoodRequest;
import com.music.musicrec.models.SongsByMoodResponse;

public class SongsByMoodControllerUtil
{
    private SongsByMoodControllerUtil() {
    }

    public static SongsByMoodResponse mapToResponse(SongsByMoodRequest songsByMoodRequest) throws MappingException {
        if (songsByMoodRequest == null) {
            throw new MappingException("Error mapping SongsByMoodRequest to SongsByMoodResponse");
        }

        try {
            return SongsByMoodResponse.builder()
                    .artistName(songsByMoodRequest.getArtistName())
                    .songName(songsByMoodRequest.getSongName())
                    .energy(songsByMoodRequest.getEnergy())
                    .build();

        } catch (Exception e) {
            throw new MappingException("Error mapping SongsByMoodRequest to SongsByMoodResponse");

        }
    }

    public static SongsByMoodResponse mapToSearchResponse(TracksEntity tracksSearch) {

        return SongsByMoodResponse.builder()
                .artistName(tracksSearch.getArtists())
                .songName(tracksSearch.getTrackName())
                .energy(tracksSearch.getEnergy())
                .build();

    }

}


