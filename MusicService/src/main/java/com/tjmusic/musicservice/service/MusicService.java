package com.tjmusic.musicservice.service;

import com.tjmusic.musicservice.model.Music;
import com.tjmusic.musicservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService {
    @Autowired
    private MusicRepository musictRepository;

    public List<Music> getMusic(){
        return musictRepository.findAll();
    }



    public Music getCommentById(Integer songsId){
        return musictRepository.findMusicBySongsId(songsId);
    }



}
