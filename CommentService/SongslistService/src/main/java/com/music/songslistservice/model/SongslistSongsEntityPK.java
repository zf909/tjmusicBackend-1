package com.music.songslistservice.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SongslistSongsEntityPK implements Serializable {
    private int songsListId;
    private int songsId;

    @Column(name = "songs_list_id")
    @Id
    public int getSongsListId() {
        return songsListId;
    }

    public void setSongsListId(int songsListId) {
        this.songsListId = songsListId;
    }

    @Column(name = "songs_id")
    @Id
    public int getSongsId() {
        return songsId;
    }

    public void setSongsId(int songsId) {
        this.songsId = songsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongslistSongsEntityPK that = (SongslistSongsEntityPK) o;
        return songsListId == that.songsListId && songsId == that.songsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(songsListId, songsId);
    }
}
