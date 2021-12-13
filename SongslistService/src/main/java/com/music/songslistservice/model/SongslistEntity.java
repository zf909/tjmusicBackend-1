package com.example.tjmusic.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "songslist", schema = "TJMusic", catalog = "")
public class SongslistEntity {
    private int songsListId;
    private int creatorId;
    private String songsListName;

    @Id
    @Column(name = "songs_list_id")
    public int getSongsListId() {
        return songsListId;
    }

    public void setSongsListId(int songsListId) {
        this.songsListId = songsListId;
    }

    @Basic
    @Column(name = "creator_id")
    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    @Basic
    @Column(name = "songs_list_name")
    public String getSongsListName() {
        return songsListName;
    }

    public void setSongsListName(String songsListName) {
        this.songsListName = songsListName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongslistEntity that = (SongslistEntity) o;
        return songsListId == that.songsListId && creatorId == that.creatorId && Objects.equals(songsListName, that.songsListName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songsListId, creatorId, songsListName);
    }
}
