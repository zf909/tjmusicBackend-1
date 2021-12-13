package com.music.songslistservice.controller;

import com.example.tjmusic.model.SongslistCollectorEntity;
import com.example.tjmusic.model.SongslistSongsEntity;
import com.example.tjmusic.repository.SongslistCollectorRepository;
import com.example.tjmusic.repository.SongslistSongsRepository;
import com.example.tjmusic.service.SongslistCollectorService;
import com.example.tjmusic.service.SongslistSongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songs")
public class SongslistSongsController {
    @Autowired
    private SongslistSongsRepository songslistSongsRepository;
    @Autowired
    private SongslistSongsService songslistSongsService;

    @GetMapping("/get_list/{songsid}")
    public List<SongslistSongsEntity> getlistBysongsid(@PathVariable Integer songsid) {
        return songslistSongsRepository.findSongslistSongsEntitiesBySongsId(songsid);
    }

    @GetMapping("/get_songs/{listid}")
    public List<SongslistSongsEntity> getcollectorBylistid(@PathVariable Integer listid) {
        return songslistSongsRepository.findSongslistSongsEntitiesBySongsListId(listid);
    }

    @PostMapping("/add")
    public ResponseEntity<SongslistSongsEntity> add(@RequestBody SongslistSongsEntity songslistSongsEntity) {

        return ResponseEntity.status(200).body(songslistSongsService.add(songslistSongsEntity));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(Integer songslistId, Integer songsid) {

        boolean result = songslistSongsService.remove(songslistId, songsid);
        if (!result)
            return ResponseEntity.status(200).body("删除失败");
        else
            return ResponseEntity.status(200).body("删除成功");

    }
}
