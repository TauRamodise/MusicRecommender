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

    @Query(value = "SELECT TOP (50) * FROM Tracks where YEAR(release_date) = :year ORDER BY popularity DESC", nativeQuery = true)
    List<TracksEntity> findAllByReleaseDate(String year);

    @Query(value ="Select * from Tracks where energy=:energy", nativeQuery = true)
    List<TracksEntity> findAllByEnergy(int energy); 

    @Query(value = "SELECT TOP (:count) * FROM Tracks t WHERE t.artists LIKE :artistQuery ORDER BY t.popularity DESC", nativeQuery = true)
    List<TracksEntity> findArtistTracks(@Param("artistQuery") String artistQuery, @Param("count") int count);
}
