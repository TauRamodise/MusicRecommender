package com.music.musicrec.repository;

import com.music.musicrec.domain.TracksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TracksRepository extends JpaRepository<TracksEntity, Long> {

    List<TracksEntity> findAll();

    @Query(value = "SELECT TOP (50) * FROM Tracks where YEAR(release_date) = :year ORDER BY popularity DESC", nativeQuery = true)
    List<TracksEntity> findAllByReleaseDate(String year);
//    @Query('Select ...where energy>5')
//    ArtistsEntity addNewArtist(String name)
//
//    @Query('Select * from TracksEntity where energy>20 order by energy')
//    List<TracksEntity>

}
