package com.music.musicrec.repository;

import com.music.musicrec.domain.TracksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TracksRepository extends JpaRepository<TracksEntity, Long> {

    List<TracksEntity> findAll();

    @Query(value = "SELECT TOP (50) * FROM Tracks WHERE YEAR(release_date) = :year ORDER BY popularity DESC", nativeQuery = true)
    List<TracksEntity> findAllByReleaseDate(String year);

    @Query(value ="SELECT TOP (10) * FROM Tracks WHERE danceability>=:min and danceability<=:max ORDER BY popularity DESC", nativeQuery = true)
    List<TracksEntity> findAllByDanceability(int min, int max);

    @Query(value ="SELECT TOP (10) * FROM Tracks WHERE energy>=:min and energy<=:max ORDER BY popularity DESC", nativeQuery = true)
    List<TracksEntity> findAllByEnergy(int min, int max);

    @Query(value = "SELECT TOP (:count) * FROM Tracks t WHERE t.artists LIKE :artistQuery ORDER BY t.popularity DESC", nativeQuery = true)
    List<TracksEntity> findArtistTracks(@Param("artistQuery") String artistQuery, @Param("count") int count);

}
