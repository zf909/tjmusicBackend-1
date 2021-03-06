package com.example.tjmusic.repository;

import com.example.tjmusic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// DAO Database Access Object
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // chazhao -- find
    // shanchu -- delete
    // zengjia -- save existed
    public User findUserByUserId(Integer userId);
    public User findUserByUserIdAndUserPassword(Integer userId,String userPassword);
}
