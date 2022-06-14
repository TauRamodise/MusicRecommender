package com.music.musicrec.services;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.exceptions.RecordNotFoundException;
import com.music.musicrec.repository.TracksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TracksServiceImpl {
    private TracksRepository tracksRepository;

    public TracksServiceImpl(TracksRepository tracksRepository) {
        this.tracksRepository = tracksRepository;
    }

    public List<TracksEntity> getSongsByMood(String mood) throws MappingException {

        int min=0;
        int max=0;

        if(!(mood.equalsIgnoreCase("CHILL")||mood.equalsIgnoreCase("VIBEY")||mood.equalsIgnoreCase("PARTY")))
        {
            throw new MappingException("Please choose a valid mood");
        }
        else
        {
            mood = mood.toUpperCase();
            switch(mood)
            {
                case "CHILL":
                      min = 0;
                      max = 50;
                      break;
                  case "VIBEY":
                      min = 51;
                      max = 70;
                      break;
                  case "PARTY":
                      min = 71;
                      max = 100;
                      break;
                  default:
                      min = 0;
                      max = 100;
                      break;

              }

            List<TracksEntity> allSongsByEnergy = tracksRepository.findAllByEnergy(min, max);

            if (allSongsByEnergy.isEmpty()) {
                throw new MappingException("No records found for given mood");
            }
            return allSongsByEnergy;
        }
    }

    public List<TracksEntity> getTopSongs(String year) throws RecordNotFoundException {

        List<TracksEntity> allTopSongs = tracksRepository.findAllByReleaseDate(year);

        if (allTopSongs.isEmpty()) {
            throw new RecordNotFoundException("No records found for given year");
        }
        return allTopSongs;
    }

    public List<TracksEntity> getArtistEssentials(String artistName, int count) {
      return tracksRepository.findArtistTracks('%' + artistName + '%', count); //
  }
}
