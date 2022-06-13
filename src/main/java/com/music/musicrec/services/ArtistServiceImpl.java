package com.music.musicrec.services;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.repository.ArtistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl {
    @Autowired
    private ArtistsRepository artistsRepository;

    public ArtistServiceImpl(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    public List<ArtistsEntity> getAllArtists() {
        return artistsRepository.findAll();
    }
}
