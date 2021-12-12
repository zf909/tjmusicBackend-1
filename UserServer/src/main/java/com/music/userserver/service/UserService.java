package com.music.userserver.service;

import com.music.userserver.model.User;
import com.music.userserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Author asus
 * @Date 2021-12-09 19:59
 * @Version 1.0
 **/
@Service
public class UserService {
    @Resource
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