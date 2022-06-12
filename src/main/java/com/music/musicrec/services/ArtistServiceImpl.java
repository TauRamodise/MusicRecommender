package com.music.musicrec.services;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.repository.ArtistsRepository;
import lombok.AllArgsConstructor;

import java.util.List;

public class ArtistServiceImpl {

    private ArtistsRepository artistsRepository;

    public ArtistServiceImpl(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    public List<ArtistsEntity> getAllArtists() {
        return artistsRepository.findAll();
    }
}
