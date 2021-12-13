package com.music.songslistservice.service;


import com.music.songslistservice.model.SongslistCollectorEntity;
import com.music.songslistservice.model.User;
import com.music.songslistservice.repository.SongslistCollectorRepository;
import com.music.songslistservice.repository.SongslistRepository;
import com.music.songslistservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongslistCollectorService {
    @Autowired
    private SongslistCollectorRepository songslistCollectorRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SongslistRepository songslistRepository;

    public SongslistCollectorEntity add(SongslistCollectorEntity songslistCollectorEntity)  {
        Integer listid = songslistCollectorEntity.getSongsListId();
        Integer collectorid = songslistCollectorEntity.getCollectorId();
        boolean focusExists = songslistRepository.existsBySongsListId(listid);

        User CreatorOptional = userRepository.findUserByUserId(collectorid);

        SongslistCollectorEntity CollectorOptional = songslistCollectorRepository.findSongslistCollectorEntityByCollectorIdAndSongsListId(listid,collectorid);
        if(CreatorOptional==null){
            throw new IllegalStateException("ID为 " + collectorid+ " 的用户不存在！");
        }
        else if(!focusExists){
            throw new IllegalStateException("歌单不存在");
        }
        else if(CollectorOptional!=null){
            throw new IllegalStateException("您已经收藏过该歌单");
        }
        else {
            return songslistCollectorRepository.save(songslistCollectorEntity);

        }
    }

    public boolean remove(Integer songslistId,Integer collectorid) {

        boolean songslistExists = songslistRepository.existsBySongsListId(songslistId);
        boolean collectorExists = userRepository.existsById(collectorid);
        SongslistCollectorEntity CollectorOptional = songslistCollectorRepository.findSongslistCollectorEntityByCollectorIdAndSongsListId(songslistId,collectorid);
        if (!songslistExists) {
            return false;
        }
        else if(!collectorExists) {
            return false;
        }
        else if(CollectorOptional==null)
        {
            return false;
        }
        else
         {
             songslistCollectorRepository.remove(songslistId,collectorid);
            return true;
        }
    }
}
