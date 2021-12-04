package com.example.tjmusic.model;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @Classname User
 * @Description TODO
 * @Author Jackie
 * @Date 2021/12/04 21:34
 * @Version 1.0
 **/
@Entity
@DynamicInsert
@DynamicUpdate
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private Integer songsId;
    private Integer userId;
    private String commentContent;
    private Date commentTime;

    public Comment() {
    }
    public String getCommentTimeId() {
        return commentTime.toString();
    }

    public String getCommentContent() {
        return commentContent;
    }
    public Integer getUserId() {
        return userId;
    }

    //public void setUserId(Integer userId) {
    //    this.userId = userId;
    //}

    public Integer getCommentId() {
        return commentId;
    }

    public Integer getSongsId() {
        return songsId;
    }



    @Override
    public String toString() {
        return "CommentId{" + commentId+
                " userId =" + userId +
                ", songId='"  + songsId + '\'' +
                '}';
    }
}
