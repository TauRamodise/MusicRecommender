package com.music.musicrec.services;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.exceptions.MappingException;
import com.music.musicrec.repository.ArtistsRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ArtistsEntity> getArtistsByGenre(String genre) throws MappingException {
        List<ArtistsEntity> top10 = artistsRepository.getTop10ByGenresContainingIgnoreCaseOrderByPopularityDesc(genre);

        if(top10.isEmpty()){
            throw new MappingException("We could not find any artists of that genre.");
        }
        return top10;
    }
    public List<ArtistsEntity> findSimilarArtists(String artistName) throws MappingException {
        List<ArtistsEntity> similarArtists = artistsRepository.getArtists(artistName);

        if (similarArtists.isEmpty()) {
            throw new MappingException("We could not find any similar artists");
        }

        return similarArtists;
    }

    public List<String> getGenres() {
        List<String> genresDB = artistsRepository.getGenresDB();
        log.debug("here");

        List<String> allGenres = new ArrayList<String>();

        genresDB.forEach((genre) -> {
            String genreSubstring = genre.substring(1, genre.length() - 1);
            String[] genresArray = genreSubstring.split(", ", 0);
            for (String gen:genresArray) {
                String genSubstring = gen.replace("'", "");
                if (!allGenres.contains(genSubstring)) {
                    allGenres.add(genSubstring);
                }
            };
                    
        });

        System.out.println("hello");
        return allGenres;
    }
}
