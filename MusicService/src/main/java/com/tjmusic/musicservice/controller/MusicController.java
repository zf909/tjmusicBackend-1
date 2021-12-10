package com.tjmusic.musicservice.controller;

import com.tjmusic.musicservice.model.Music;
import com.tjmusic.musicservice.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Classname MusicController
 * @Description TODO
 * @Author asus
 * @Date 2021-12-09 22:17
 * @Version 1.0
 **/
@RestController
@RequestMapping("music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/getAllMusic")
    public List<Music> getAllMusic() {
        return musicService.getMusic();
    }

    @GetMapping("/get_music_by_name/{songsName}")
    public Music findSongsBySongsName(@PathVariable String songsName) {
        return musicService.getSongsBySongsName(songsName);
    }

    @GetMapping("/get_music_by_name_fuzzy/{songsName}")
    public Music findSongsByFuzzySongsName(@PathVariable String songsName) {
        return musicService.getSongsByFuzzySongsName("%"+songsName+"%");
    }


    @GetMapping("/get_music_by_songsId/{songsId}")
    public Music findSongsById(@PathVariable Integer songsId) {
        return musicService.getSongsById(songsId);
    }


}