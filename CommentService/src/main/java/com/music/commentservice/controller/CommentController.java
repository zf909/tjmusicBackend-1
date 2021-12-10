package com.music.commentservice.controller;

import com.music.commentservice.model.Comment;
import com.music.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add_comment")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }


    @GetMapping("/get_comment_by_Id/{commentId}")
    public Comment findCommentByCommentId(@PathVariable Integer commentId) {
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/delete_comment_by_Id/{commentId}")
    public Comment deleteCommentByCommentId(@PathVariable Integer commentId) {
        return commentService.deleteCommentById(commentId);
    }

    @GetMapping("/get_comment_by_songsId/{songsId}")
    public Comment findCommentBySongsId(@PathVariable Integer songsId) {
        return commentService.getCommentBySongsId(songsId);
    }

    @GetMapping("/get_comment_by_userId/{userId}")
    public Comment findCommentByUserId(@PathVariable Integer userId) {
        return commentService.getCommentByUserId(userId);
    }
}