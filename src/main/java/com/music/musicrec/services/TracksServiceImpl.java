package com.music.musicrec.services;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.repository.TracksRepository;

import java.util.List;

public class TracksServiceImpl {
    private TracksRepository tracksRepository;

    public TracksServiceImpl(TracksRepository tracksRepository) {
        this.tracksRepository = tracksRepository;
    }

    public List<TracksEntity> getSongsByMood() {
        return tracksRepository.findAll();

    }

    public List<TracksEntity> getTopSongs(String year) {
        return tracksRepository.getTopSongs(year);
    }

}
