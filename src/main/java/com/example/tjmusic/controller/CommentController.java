package com.example.tjmusic.controller;


import com.example.tjmusic.model.Comment;
import com.example.tjmusic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname CommentController
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/04 21:41
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1/user")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/getAllComment")
    public List<Comment> getAllComment() {
        return commentService.getComment();
    }



    @GetMapping("/get_comment/{commentId}")
    public Comment findUserById(@PathVariable Integer commentId) {
        return commentService.getCommentById(commentId);
    }


}