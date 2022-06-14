package com.music.musicrec.repository;

import com.music.musicrec.domain.ArtistsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistsRepository extends JpaRepository<ArtistsEntity, Long> {

    List<ArtistsEntity> findAll();
    ArtistsEntity getArtistsEntitiesById(String id);

    @Query(
            value = "DECLARE @id varchar(100) = (SELECT id FROM Artists WHERE name=:artistName)\n" +
                    "            DECLARE @genres varchar(100) = (SELECT genres FROM Artists WHERE id = @id)\n" +
                    "            DECLARE @genre1 varchar(100) = JSON_VALUE(REPLACE(@genres, '''', '\"'), '$[0]')\n" +
                    "            DECLARE @genre2 varchar(100) = JSON_VALUE(REPLACE(@genres, '''', '\"'), '$[1]')\n" +
                    "            SELECT TOP 10 * FROM Artists " +
                    "            WHERE genres LIKE '%''' + @genre1+ '''%' AND genres LIKE '%''' + @genre2+ '''%' " +
                    "            AND id != @id " +
                    "            ORDER BY popularity DESC",
            nativeQuery = true)
    List<ArtistsEntity> getArtists(String artistName);
  
    @Query(
        value="Select genres from Artists",
        nativeQuery = true)
    List<String> getGenresDB();
}

