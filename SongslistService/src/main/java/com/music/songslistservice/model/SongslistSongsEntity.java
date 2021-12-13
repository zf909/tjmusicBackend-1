package com.example.tjmusic.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "songslist_songs", schema = "TJMusic", catalog = "")
@IdClass(SongslistSongsEntityPK.class)
public class SongslistSongsEntity {
    private int songsListId;
    private int songsId;

    @Id
    @Column(name = "songs_list_id")
    public int getSongsListId() {
        return songsListId;
    }

    public void setSongsListId(int songsListId) {
        this.songsListId = songsListId;
    }

    @Id
    @Column(name = "songs_id")
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
        SongslistSongsEntity that = (SongslistSongsEntity) o;
        return songsListId == that.songsListId && songsId == that.songsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(songsListId, songsId);
    }
}
