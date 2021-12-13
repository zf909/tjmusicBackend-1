package com.music.songslistservice.controller;

import com.example.tjmusic.model.FollowerEntity;
import com.example.tjmusic.model.SongslistEntity;
import com.example.tjmusic.repository.SongslistRepository;
import com.example.tjmusic.service.SongslistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songslist")
public class SongslistController {
    @Autowired
    private SongslistRepository songslistRepository;
    @Autowired
    private SongslistService songslistService;

    @GetMapping("/get/{CreatorId}")
    public List<SongslistEntity> getlistByuserId(@PathVariable Integer CreatorId) {
        return songslistRepository.findSongslistEntityByCreatorId(CreatorId);
    }

    @PostMapping("/add")
    public ResponseEntity<SongslistEntity> add(@RequestBody SongslistEntity songslist) {

        return ResponseEntity.status(200).body(songslistService.add(songslist));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(Integer songslistid) {

        boolean result = songslistService.remove(songslistid);
        if (!result)
            return ResponseEntity.status(200).body("没有对应歌单");
        else
            return ResponseEntity.status(200).body("删除成功");

    }
    //public
}
