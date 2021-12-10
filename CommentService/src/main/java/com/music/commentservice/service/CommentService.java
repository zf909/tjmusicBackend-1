package com.music.commentservice.service;

import com.music.commentservice.model.Comment;
import com.music.commentservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CommentService
 * @Description TODO
 * @Author asus
 * @Date 2021-12-09 20:18
 * @Version 1.0
 **/
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComment(){
        return commentRepository.findAll();
    }



    public Comment getCommentById(Integer commentId){
        return commentRepository.findCommentByCommentId(commentId);
    }



}
