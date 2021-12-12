package com.music.userserver.controller;

import com.music.userserver.model.User;
import com.music.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Author asus
 * @Date 2021-12-09 19:58
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
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
    public User findUserById(@PathVariable("userId") Integer userId) {
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