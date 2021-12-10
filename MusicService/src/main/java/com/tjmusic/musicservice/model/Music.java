package com.tjmusic.musicservice.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
@DynamicInsert
@DynamicUpdate
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songsId;
    private Integer songsCheck;
    private String songsArtistsName;
    private String songsName;
    private String songsImage;

    public Music() {
    }
    public String getSongsArtistsName() {
        return songsArtistsName;
    }

    public void setSongsId(Integer songsId) {
        this.songsId = songsId;
    }

    public Integer getSongsCheck() {
        return songsCheck;
    }

    public void setSongsCheck(Integer songsCheck) {
        this.songsCheck = songsCheck;
    }

    public void setSongsArtistsName(String songsArtistsName) {
        this.songsArtistsName = songsArtistsName;
    }

    public String getSongsName() {
        return songsName;
    }

    public void setSongsName(String songsName) {
        this.songsName = songsName;
    }

    public String getSongsImage() {
        return songsImage;
    }

    public void setSongsImage(String songsImage) {
        this.songsImage = songsImage;
    }





    @Override
    public String toString() {
        return "songsId{" + songsId+
                " songsCheck =" + songsCheck +
                ", songsName='"  + songsName + '\'' +
                '}';
    }
}