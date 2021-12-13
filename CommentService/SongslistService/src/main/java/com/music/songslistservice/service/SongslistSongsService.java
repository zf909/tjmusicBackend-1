package com.music.songslistservice.service;


import com.music.songslistservice.model.SongslistSongsEntity;
import com.music.songslistservice.repository.MusicRepository;
import com.music.songslistservice.repository.SongslistRepository;
import com.music.songslistservice.repository.SongslistSongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongslistSongsService {
    @Autowired
    private SongslistSongsRepository songslistSongsRepository;
    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private SongslistRepository songslistRepository;

    public SongslistSongsEntity add(SongslistSongsEntity songslistSongsEntity)  {
        Integer listid = songslistSongsEntity.getSongsListId();
        Integer songsid = songslistSongsEntity.getSongsId();
        boolean listExists = songslistRepository.existsBySongsListId(listid);
        boolean songsexists=musicRepository.existsById(songsid);

        SongslistSongsEntity musicOptional = songslistSongsRepository.findSongslistSongsEntityBySongsIdAndSongsListId(listid,songsid);
        if(!listExists){
            throw new IllegalStateException("歌单不存在！");
        }
        else if(!songsexists){
            throw new IllegalStateException("歌曲不存在");
        }
        else if(musicOptional!=null){
            throw new IllegalStateException("歌单包含该歌曲");
        }
        else {
            return songslistSongsRepository.save(songslistSongsEntity);

        }
    }

    public boolean remove(Integer songslistId,Integer songsid) {

        boolean songslistExists = songslistRepository.existsBySongsListId(songslistId);
        boolean songsExists = musicRepository.existsById(songsid);
        SongslistSongsEntity musicOptional = songslistSongsRepository.findSongslistSongsEntityBySongsIdAndSongsListId(songsid,songslistId);
        if (!songslistExists) {
            return false;
        }
        else if(!songsExists) {
            return false;
        }
        else if(musicOptional==null)
        {
            return false;
        }
        else
        {
            songslistSongsRepository.remove(songslistId,songsid);
            return true;
        }
    }
}
