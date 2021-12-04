package com.example.tjmusic.service;


import com.example.tjmusic.model.Comment;
import com.example.tjmusic.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname CommentService
 * @Description TODO
 * @Author Administrator
 * @Date 2021/12/04 21:38
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