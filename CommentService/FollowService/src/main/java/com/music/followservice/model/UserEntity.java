package com.music.followservice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "TJMusic", catalog = "")
public class UserEntity {
    private int userId;
    private String userPassword;
    private String userEmail;
    private String userArea;
    private Integer userAge;
    private String userContent;
    private String userName;
    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_area")
    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    @Basic
    @Column(name = "user_age")
    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_content")
    public String getUserContent() {
        return userContent;
    }

    public void setUserContent(String userContent) {
        this.userContent = userContent;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId && Objects.equals(userPassword, that.userPassword) && Objects.equals(userEmail, that.userEmail) && Objects.equals(userArea, that.userArea) && Objects.equals(userAge, that.userAge) && Objects.equals(userContent, that.userContent)&& Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userEmail, userArea, userAge, userContent,userName);
    }
}
