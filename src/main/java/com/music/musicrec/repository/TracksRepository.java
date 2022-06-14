package com.music.musicrec.repository;

import com.music.musicrec.domain.ArtistsEntity;
import com.music.musicrec.domain.TracksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TracksRepository extends JpaRepository<TracksEntity, Long> {

    List<TracksEntity> findAll();
    // @Query("SELECT TOP (50) * FROM [Artists_DB].[dbo].[Tracks] where release_date LIKE '% :id %' order by popularity desc");
    List<TracksEntity> getTopSongs(String year);

//    @Query('Select ...where energy>5')
//    ArtistsEntity addNewArtist(String name)
}
