package com.music.musicrec.services;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.repository.TracksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TracksServiceImpl {
    private TracksRepository tracksRepository;

    public TracksServiceImpl(TracksRepository tracksRepository) {
        this.tracksRepository = tracksRepository;
    }

    public List<TracksEntity> getSongsByMood() {
        return tracksRepository.findAll();

    }

    public List<TracksEntity> getTopSongs(String year) throws MappingException {

        List<TracksEntity> allTopSongs = tracksRepository.findAllByReleaseDate(year);

        if (allTopSongs.isEmpty()) {
            throw new MappingException("No records found for given year");
        }
        return allTopSongs;
    }

}
