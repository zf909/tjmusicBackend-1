package com.music.communityservice.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Classname Community
 * @Description TODO
 * @Author .
 * @Date 2021/11/09 13:47
 * @Version 1.0
 **/
@Entity
@DynamicInsert
@DynamicUpdate
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer momentId;
    private Integer userId;
    private String momentContent;
    private String momentTime;
    private Integer songsId;

    public Community() {
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMomentContent() {
        return momentContent;
    }

    public void setMomentContent(String momentContent) {
        this.momentContent = momentContent;
    }

    public String getMomentTime() {
        return momentTime;
    }

    public void setMomentTime(String momentTime) {
        this.momentTime = momentTime;
    }

    public Integer getSongsId() {
        return songsId;
    }

    public void setSongsId(Integer songsId) {
        this.songsId = songsId;
    }
}
