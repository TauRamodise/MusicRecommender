package com.music.musicrec.services;

import com.music.musicrec.domain.TracksEntity;
import com.music.musicrec.repository.TracksRepository;
import org.springframework.stereotype.Service;

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

    public List<TracksEntity> getTopSongs() {
        return tracksRepository.findAll();
    }

}
