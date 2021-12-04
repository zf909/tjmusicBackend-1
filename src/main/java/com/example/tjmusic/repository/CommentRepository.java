package com.example.tjmusic.repository;

import com.example.tjmusic.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    public Comment findCommentByCommentId(Integer commentId);
}
