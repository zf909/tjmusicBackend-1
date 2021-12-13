package com.example.tjmusic.repository;

import com.example.tjmusic.model.SongslistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SongslistRepository extends JpaRepository<SongslistEntity, Integer> {
    //    @Query(value = "select t from SongslistEntity t where t.focusId = ?1")
//    public Optional<List<FollowerEntity>> findAllBysongs_list_id(Integer focusId);
    //public List<SongslistEntity> findSongslistEntityByUserId(Integer userId);
    List<SongslistEntity> findSongslistEntityByCreatorId(Integer CreatorId);

    //public SongslistEntity deleteSongslistEntityBySongsListId(Integer songslistId);
    boolean existsBySongsListId(Integer songslistId);

    //        @Transactional
//        @Modifying
//        public SongslistEntity removeSongslistEntityBySongsListId(Integer songslistId);
    @Transactional
    @Modifying
    @Query(value = "delete from songslist where songs_list_id = ?1 ", nativeQuery = true)
    void remove(Integer songslistId);
}
