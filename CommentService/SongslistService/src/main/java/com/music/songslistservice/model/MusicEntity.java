package com.music.songslistservice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "music", schema = "TJMusic", catalog = "")
public class MusicEntity {
    private int songsId;
    private String songsName;
    private String songsArtistsName;
    private String songsImage;
    private int songsCheck;

    @Id
    @Column(name = "songs_id")
    public int getSongsId() {
        return songsId;
    }

    public void setSongsId(int songsId) {
        this.songsId = songsId;
    }

    @Basic
    @Column(name = "songs_name")
    public String getSongsName() {
        return songsName;
    }

    public void setSongsName(String songsName) {
        this.songsName = songsName;
    }

    @Basic
    @Column(name = "songs_artists_name")
    public String getSongsArtistsName() {
        return songsArtistsName;
    }

    public void setSongsArtistsName(String songsArtistsName) {
        this.songsArtistsName = songsArtistsName;
    }

    @Basic
    @Column(name = "songs_image")
    public String getSongsImage() {
        return songsImage;
    }

    public void setSongsImage(String songsImage) {
        this.songsImage = songsImage;
    }

    @Basic
    @Column(name = "songs_check")
    public int getSongsCheck() {
        return songsCheck;
    }

    public void setSongsCheck(int songsCheck) {
        this.songsCheck = songsCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicEntity that = (MusicEntity) o;
        return songsId == that.songsId && songsCheck == that.songsCheck && Objects.equals(songsName, that.songsName) && Objects.equals(songsArtistsName, that.songsArtistsName) && Objects.equals(songsImage, that.songsImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songsId, songsName, songsArtistsName, songsImage, songsCheck);
    }
}
