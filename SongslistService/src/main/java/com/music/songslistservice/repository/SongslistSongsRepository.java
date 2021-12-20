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
    List<SongslistSongsEntity> findSongslistSongsEntitiesBySongsListId(Integer songslistId);

    List<SongslistSongsEntity> findSongslistSongsEntitiesBySongsId(Integer SongsId);

    SongslistSongsEntity findSongslistSongsEntityBySongsIdAndSongsListId(Integer songslistId, Integer SongsId);

    boolean existsBySongsListId(Integer songslistId);

    @Transactional
    @Modifying
    @Query(value = "delete from songslist_songs where songs_list_id = ?1 and songs_id = ?2", nativeQuery = true)
    void remove(Integer songslistId, Integer songsid);
}
