package com.example.tjmusic.repository;

import com.example.tjmusic.model.MusicEntity;
import com.example.tjmusic.model.SongslistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<MusicEntity, Integer> {

}
