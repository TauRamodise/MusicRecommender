package com.music.musicrec.repository;

import com.music.musicrec.domain.ArtistsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistsRepository extends JpaRepository<ArtistsEntity, Long> {

    List<ArtistsEntity> findAll();
//    @Query('Select ...where energy>5')
//    ArtistsEntity addNewArtist(String name)
}
