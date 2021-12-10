package com.tjmusic.musicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tjmusic.musicservice.model.Music;



@Repository
public interface MusicRepository extends JpaRepository<Music,Integer> {

    public Music findMusicBySongsNameLike(String songsName);
    public Music findMusicBySongsName(String songsName);
    public Music findMusicBySongsId(Integer songsId);
}