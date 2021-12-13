package com.music.songslistservice.controller;

import com.example.tjmusic.model.SongslistCollectorEntity;

import com.example.tjmusic.service.SongslistCollectorService;
import com.music.songslistservice.repository.SongslistCollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("listcollect")
public class SongslistCollectorController {
    @Autowired
    private SongslistCollectorRepository songslistCollectorRepository;
    @Autowired
    private SongslistCollectorService songslistCollectorService;

    @GetMapping("/get_list/{collectorid}")
    public List<SongslistCollectorEntity> getlistBycollectorid(@PathVariable Integer collectorid) {
        return songslistCollectorRepository.findSongslistCollectorEntityByCollectorId(collectorid);
    }

    @GetMapping("/get_collector/{listid}")
    public List<SongslistCollectorEntity> getcollectorBylistid(@PathVariable Integer listid) {
        return songslistCollectorRepository.findSongslistCollectorEntityBySongsListId(listid);
    }

    @PostMapping("/add")
    public ResponseEntity<SongslistCollectorEntity> add(@RequestBody SongslistCollectorEntity songslistCollector) {

        return ResponseEntity.status(200).body(songslistCollectorService.add(songslistCollector));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(Integer songslistId, Integer collectorid) {

        boolean result = songslistCollectorService.remove(songslistId, collectorid);
        if (!result)
            return ResponseEntity.status(200).body("删除失败");
        else
            return ResponseEntity.status(200).body("删除成功");

    }
}
