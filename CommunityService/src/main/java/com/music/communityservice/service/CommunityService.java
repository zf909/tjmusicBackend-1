package com.music.communityservice.service;

import com.music.communityservice.model.Community;
import com.music.communityservice.repository.CommunityRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {
    @Autowired
    private CommunityRepository communityRepository;

    public List<Community> getCommunity() {
        return communityRepository.findAll();
    }

    public Community addCommunity(Community community){
        return communityRepository.save(community);
    }

    public void deleteCommunity(Community community) {
        communityRepository.delete(community);
    }

    public Community getCommunityById(Integer momentId) {
        return communityRepository.findCommunityByMomentId(momentId);
    }

}