package com.music.songslistservice.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
/**
 * @Classname User
 * @Description TODO
 * @Author Administrator
 * @Date 2021/11/24 19:34
 * @Version 1.0
 **/
@Entity
@DynamicInsert
@DynamicUpdate
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userPassword;
    private String userEmail;

    private static final long serialVersionUID = 1L;
    public User() {
        super();
    }
    public User(Integer userId, String userPassword, String userEmail) {
        super();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
