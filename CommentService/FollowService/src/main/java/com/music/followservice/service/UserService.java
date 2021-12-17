package com.music.followservice.service;


import com.music.followservice.model.User;
import com.music.followservice.model.UserEntity;
import com.music.followservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserServicw
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/24 19:38
 * @Version 1.0
 **/
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUser(){
        return userRepository.findAll();
    }

    public UserEntity addUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity getUserById(Integer userId){
        return userRepository.findUserEntityByUserId(userId);
    }

    public String userLogin(Integer userId,String userPassword){
        if(userRepository.findUserEntityByUserId(userId)==null)
            return "-1";
        else if(userRepository.findUserEntityByUserIdAndUserPassword(userId,userPassword)==null)
            return "401";
        else
            return "200";
    }

}
