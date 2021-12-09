package com.music.userserver.repository;

import com.music.userserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserRepository
 * @Description TODO
 * @Author asus
 * @Date 2021-12-09 20:00
 * @Version 1.0
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // chazhao -- find
    // shanchu -- delete
    // zengjia -- save existed
    public User findUserByUserId(Integer userId);
    public User findUserByUserIdAndUserPassword(Integer userId,String userPassword);
}