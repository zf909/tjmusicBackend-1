package com.music.songslistservice.controller;


import com.music.songslistservice.service.SongslistService;
import com.music.songslistservice.model.SongslistEntity;
import com.music.songslistservice.repository.SongslistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songslist")
@CrossOrigin
public class SongslistController {
    @Autowired
    private SongslistRepository songslistRepository;
    @Autowired
    private SongslistService songslistService;

    @GetMapping("/get/{CreatorId}")
    public List<SongslistEntity> getlistByuserId(@PathVariable Integer CreatorId) {
        return songslistRepository.findSongslistEntityByCreatorId(CreatorId);
    }
    @GetMapping("/getlist/{SongsListId}")
    public SongslistEntity FindlistBySongsListId(@PathVariable Integer SongsListId) {
        return songslistRepository.findSongslistEntityBySongsListId(SongsListId);
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
