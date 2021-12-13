package com.music.songslistservice.repository;


import com.music.songslistservice.model.SongslistSongsEntity;
import com.music.songslistservice.model.SongslistSongsEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SongslistSongsRepository extends JpaRepository<SongslistSongsEntity, SongslistSongsEntityPK> {
    public List<SongslistSongsEntity> findSongslistSongsEntitiesBySongsListId(Integer songslistId);
    public List<SongslistSongsEntity> findSongslistSongsEntitiesBySongsId(Integer SongsId);
    public SongslistSongsEntity findSongslistSongsEntityBySongsIdAndSongsListId(Integer songslistId,Integer SongsId);

    public boolean existsBySongsListId(Integer songslistId);

    @Transactional
    @Modifying
    @Query(value = "delete from songslist_songs where songs_list_id = ?1 and songs_id = ?2", nativeQuery = true)
    public void remove(Integer songslistId, Integer songsid);
}
