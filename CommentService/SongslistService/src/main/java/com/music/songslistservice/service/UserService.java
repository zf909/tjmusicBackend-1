package com.music.songslistservice.service;


import com.music.songslistservice.model.User;
import com.music.songslistservice.repository.UserRepository;
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

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Integer userId){
        return userRepository.findUserByUserId(userId);
    }

    public String userLogin(Integer userId,String userPassword){
        if(userRepository.findUserByUserId(userId)==null)
            return "-1";
        else if(userRepository.findUserByUserIdAndUserPassword(userId,userPassword)==null)
            return "401";
        else
            return "200";
    }

}
