package com.tjmusic.musicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tjmusic.musicservice.model.Music;



@Repository
public interface MusicRepository extends JpaRepository<Music,Integer> {

    Music findMusicBySongsNameLike(String songsName);
    Music findMusicBySongsName(String songsName);
    Music findMusicBySongsId(Integer songsId);
}