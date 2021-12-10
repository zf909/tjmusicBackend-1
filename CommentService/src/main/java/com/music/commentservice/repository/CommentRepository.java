package com.music.commentservice.repository;

import com.music.commentservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname CommentRepository
 * @Description TODO
 * @Author asus
 * @Date 2021-12-09 20:18
 * @Version 1.0
 **/
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    public Comment findCommentByCommentId(Integer commentId);
}
