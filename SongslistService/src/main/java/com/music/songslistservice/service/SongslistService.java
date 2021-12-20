package com.music.songslistservice.service;


import com.music.songslistservice.model.SongslistEntity;
import com.music.songslistservice.model.User;
import com.music.songslistservice.repository.SongslistRepository;
import com.music.songslistservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongslistService {
    @Autowired
    private SongslistRepository songslistRepository;
    @Autowired
    private UserRepository userRepository;

    //    @Autowired
//    private MusicRepository musicRepository;
    public SongslistEntity add(SongslistEntity songslistEntity) {
        Integer CreatorId = songslistEntity.getCreatorId();

        User CreatorOptional = userRepository.findUserByUserId(CreatorId);
        //MusicEntity MusicOptional=musicRepository.findById()
        if (CreatorOptional == null) {
            throw new IllegalStateException("ID为 " + CreatorId + " 的用户不存在！");
        } else {
            return songslistRepository.save(songslistEntity);
//            JSONObject json = new JSONObject();
//            json.put("status", 200);
//            json.put("message", "新增关注成功");
//     //       throw new IllegalStateException("关注成功");
//            System.out.print(json);
//            return json;
        }
    }

    public boolean remove(Integer songslistId) {

        boolean focusExists = songslistRepository.existsBySongsListId(songslistId);
        System.out.print(" " + focusExists);
        if (!focusExists) {
            return false;
        } else {
            songslistRepository.remove(songslistId);
//            JSONObject json = new JSONObject();
//            json.put("status", 200);
//            json.put("message", "删除成功");

            return true;
        }
    }

}
