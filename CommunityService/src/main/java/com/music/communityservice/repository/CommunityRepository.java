package com.music.communityservice.repository;

import com.music.communityservice.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

// DAO Database Access Object
@Repository
public interface CommunityRepository extends JpaRepository<Community,Integer> {
    Community findCommunityByMomentId(Integer momentId);
}

