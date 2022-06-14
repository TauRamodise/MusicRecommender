package com.music.musicrec.services;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.repository.ArtistsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArtistServiceImpl {
    @Autowired
    private ArtistsRepository artistsRepository;

    public ArtistServiceImpl(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    public List<ArtistsEntity> getAllArtists() {
        return artistsRepository.findAll();
    }

    public ArtistsEntity getOneArtists(String id) {
        ArtistsEntity findOne = artistsRepository.getArtistsEntitiesById(id);
        log.debug("here");
        System.out.println(findOne);
        return findOne;
    }

    public List<ArtistsEntity> findSimilarArtists(String artistName) throws MappingException {
        List<ArtistsEntity> similarArtists = artistsRepository.getArtists(artistName);

        if (similarArtists.isEmpty()) {
            throw new MappingException("We could not find any similar artists");
        }

        return similarArtists;
    }


}
