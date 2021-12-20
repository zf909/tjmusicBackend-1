package com.music.songslistservice.repository;


import com.music.songslistservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DAO Database Access Object
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // chazhao -- find
    // shanchu -- delete
    // zengjia -- save existed
    User findUserByUserId(Integer userId);

    User findUserByUserIdAndUserPassword(Integer userId, String userPassword);
}
