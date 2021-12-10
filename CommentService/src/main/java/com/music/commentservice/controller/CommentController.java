package com.music.commentservice.controller;

import com.music.commentservice.model.Comment;
import com.music.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname CommentController
 * @Description TODO
 * @Author asus
 * @Date 2021-12-09 20:17
 * @Version 1.0
 **/
@RestController
@RequestMapping("comment")
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