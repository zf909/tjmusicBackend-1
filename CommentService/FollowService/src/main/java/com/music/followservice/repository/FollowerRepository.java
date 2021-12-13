package com.music.followservice.repository;


import com.music.followservice.model.FollowerEntity;
import com.music.followservice.model.FollowerEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface FollowerRepository extends JpaRepository<FollowerEntity, FollowerEntityPK> {

    @Query(value = "select t from FollowerEntity t where t.focusId= ?1 and t.fansId = ?2")
    public Optional<FollowerEntity> findById(Integer focusId, Integer fansId);

    @Query(value = "select t from FollowerEntity t where t.focusId = ?1")
    public Optional<List<FollowerEntity>> findAllByfocusId(Integer focusId);

    @Query(value = "select t from FollowerEntity t where t.fansId = ?1")
    public Optional<List<FollowerEntity>> findAllByfansId(Integer fansId);

    @Transactional
    @Modifying
    @Query(value = "delete from follower where focus_Id = ?1 and fans_Id = ?2", nativeQuery = true)
    public void remove(Integer focusId, Integer fansId);

}