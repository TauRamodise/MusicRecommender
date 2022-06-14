package com.music.musicrec.services;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.models.Danceability;
import com.music.musicrec.repository.TracksRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TracksServiceImpl {
    private TracksRepository tracksRepository;

    public TracksServiceImpl(TracksRepository tracksRepository) {
        this.tracksRepository = tracksRepository;
    }

    public List<TracksEntity> getSongsByMood(int energy) {
        return tracksRepository.findAllByEnergy(energy);

    }

    public List<TracksEntity> getTopSongs(String year) throws MappingException {

        List<TracksEntity> allTopSongs = tracksRepository.findAllByReleaseDate(year);

        if (allTopSongs.isEmpty()) {
            throw new MappingException("No records found for given year");
        }
        return allTopSongs;
    }

    public List<TracksEntity> getDanceabilityPlaylist(String danceability) throws MappingException {

        List<TracksEntity> dancePlaylist = new ArrayList<TracksEntity>();

        if(!(danceability.equalsIgnoreCase("CHILL")||danceability.equalsIgnoreCase("VIBEY")||danceability.equalsIgnoreCase("PARTY")))
        {
            throw new MappingException("Please choose a valid danceability score");
        }
        else
        {
            danceability = danceability.toUpperCase();
            switch(danceability)
            {
                case "CHILL":
                    dancePlaylist = tracksRepository.findAllByDanceability(0,50);
                    break;
                case "VIBEY":
                    dancePlaylist = tracksRepository.findAllByDanceability(51,70);
                    break;
                case "PARTY":
                    dancePlaylist = tracksRepository.findAllByDanceability(71,100);
                    break;
                default:
                    dancePlaylist = tracksRepository.findAllByDanceability(0,100);
                    break;

            }

            if (dancePlaylist.isEmpty()) {
                throw new MappingException("No records found for given danceability score");
            }
            return dancePlaylist;
        }
    }

}
