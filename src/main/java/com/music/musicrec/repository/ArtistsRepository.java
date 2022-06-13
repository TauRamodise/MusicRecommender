package com.music.musicrec.repository;

import com.music.musicrec.domain.ArtistsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistsRepository extends JpaRepository<ArtistsEntity, Long> {

//    @Query("select * from artists")

    List<ArtistsEntity> findAll();
    ArtistsEntity getArtistsEntitiesById(String id);


//    List<ArtistsEntity> getAll();

}

