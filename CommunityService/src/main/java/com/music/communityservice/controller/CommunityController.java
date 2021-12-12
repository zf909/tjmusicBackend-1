package com.music.communityservice.controller;

import com.music.communityservice.model.Community;
import com.music.communityservice.service.CommunityService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;


@RestController
@RequestMapping("/api/v1/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @GetMapping()
    public List<Community> getAllCommunity() {
        return communityService.getCommunity();
    }

    @GetMapping("/{momentId}")
    public Community findCommunityById(@PathVariable Integer momentId) {
        return communityService.getCommunityById(momentId);
    }

    @PostMapping("/{community}")
    public Community addCommunity(@RequestBody Community community) {
        return communityService.addCommunity(community);
    }

    @DeleteMapping("/{community}")
    public void deleteCommunity(@RequestBody Community community) {
        communityService.deleteCommunity(community);
    }

}


