package com.music.followservice.controller;



import com.music.followservice.model.FollowerEntity;
import com.music.followservice.service.FollowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("follow")
public class FollowerController {

    @Autowired
    FollowerService followerService;
    @GetMapping("/get_focus/{focusId}")
    public List<FollowerEntity> getAllfansByfocusId(@PathVariable Integer focusId) {
        return followerService.getAllfansByfocusId(focusId);
    }
    @GetMapping("/get_fans/{fansId}")
    public List<FollowerEntity> getAllfocusByfansId(@PathVariable Integer fansId) {
        return followerService.getAllfocusByfansId(fansId);
    }

    @PostMapping("/add")
    public ResponseEntity<FollowerEntity> addfollower(@RequestBody FollowerEntity follower) {
        //return followerService.addfollow(follower);
        return ResponseEntity.status(200).body(followerService.addfollow(follower));
    }
    @DeleteMapping("/remove")
    public ResponseEntity<String> removefollower(Integer focusId, Integer fansId) {

        boolean result=followerService.removefollow(focusId, fansId);
        if(!result)
            return ResponseEntity.status(200).body("没有对应用户");
        else
            return ResponseEntity.status(200).body("删除成功");
    }
}
