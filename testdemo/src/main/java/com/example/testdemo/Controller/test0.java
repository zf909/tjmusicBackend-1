package com.example.testdemo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname test0
 * @Description TODO
 * @Author asus
 * @Date 2021-12-08 16:43
 * @Version 1.0
 **/

@RestController
public class test0 {
    @RequestMapping("test0")
    @ResponseBody
    public String test1(){
        return "test1";
    }
    @RequestMapping("demo/test0")
    @ResponseBody
    public String test2(){
        return "test2";
    }
}
