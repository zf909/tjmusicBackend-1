package com.music.songslistservice.repository;

import com.example.tjmusic.model.SongslistCollectorEntity;
import com.example.tjmusic.model.SongslistCollectorEntityPK;
import com.example.tjmusic.model.SongslistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongslistCollectorRepository extends JpaRepository<SongslistCollectorEntity, SongslistCollectorEntityPK> {
    List<SongslistCollectorEntity> findSongslistCollectorEntityByCollectorId(Integer collectorid);

    List<SongslistCollectorEntity> findSongslistCollectorEntityBySongsListId(Integer songslistId);

    boolean existsBySongsListId(Integer songslistId);

    SongslistCollectorEntity findSongslistCollectorEntityByCollectorIdAndSongsListId(Integer songslistId, Integer collectorId);

    @Transactional
    @Modifying
    @Query(value = "delete from songslist_collector where songs_list_id = ?1 and collector_id = ?2", nativeQuery = true)
    void remove(Integer songslistId, Integer collectorid);

}