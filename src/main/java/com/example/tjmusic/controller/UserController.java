package com.example.tjmusic.controller;

import com.example.tjmusic.model.User;
import com.example.tjmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/24 19:41
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public List<User> getAllUser() {
        return userService.getUser();
    }

    @PostMapping("/add_user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/get_user/{userId}")
    public User findUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/login")
    public String userLogin(@RequestParam("userId") Integer userId, @RequestParam("userPassword") String userPassword) {
        String result = userService.userLogin(userId, userPassword);
        if (result == "-1")
            return "not found";
        else if (result == "401")
            return "error";
        else
            return "success login";

    }
}
