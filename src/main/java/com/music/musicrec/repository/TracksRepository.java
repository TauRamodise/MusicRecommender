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

    @Query(value ="Select * from Tracks where energy=:energy", nativeQuery = true)
    List<TracksEntity> findAllByEnergy(int energy);

    @Query(value ="SELECT TOP (10) * FROM Tracks WHERE danceability>=:min and danceability<=:max ORDER BY popularity DESC", nativeQuery = true)
    List<TracksEntity> findAllByDanceability(int min, int max);
}
