package com.music.followservice.repository;


import com.music.followservice.model.User;
import com.music.followservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// DAO Database Access Object
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    // chazhao -- find
    // shanchu -- delete
    // zengjia -- save existed
    public UserEntity findUserEntityByUserId(Integer userId);
    public UserEntity findUserEntityByUserIdAndUserPassword(Integer userId,String userPassword);
}
