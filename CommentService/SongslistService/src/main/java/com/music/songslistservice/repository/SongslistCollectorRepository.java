package com.music.songslistservice.repository;


import com.music.songslistservice.model.SongslistCollectorEntity;
import com.music.songslistservice.model.SongslistCollectorEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongslistCollectorRepository extends JpaRepository<SongslistCollectorEntity, SongslistCollectorEntityPK> {
    public List<SongslistCollectorEntity> findSongslistCollectorEntityByCollectorId(Integer collectorid);
    public List<SongslistCollectorEntity> findSongslistCollectorEntityBySongsListId(Integer songslistId);
    public boolean existsBySongsListId(Integer songslistId);
    public SongslistCollectorEntity findSongslistCollectorEntityByCollectorIdAndSongsListId(Integer songslistId,Integer collectorId);
    @Transactional
    @Modifying
    @Query(value = "delete from songslist_collector where songs_list_id = ?1 and collector_id = ?2", nativeQuery = true)
    public void remove(Integer songslistId, Integer collectorid);

}
