package com.example.tjmusic.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SongslistCollectorEntityPK implements Serializable {
    private int songsListId;
    private int collectorId;

    @Column(name = "songs_list_id")
    @Id
    public int getSongsListId() {
        return songsListId;
    }

    public void setSongsListId(int songsListId) {
        this.songsListId = songsListId;
    }

    @Column(name = "collector_id")
    @Id
    public int getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(int collectorId) {
        this.collectorId = collectorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongslistCollectorEntityPK that = (SongslistCollectorEntityPK) o;
        return songsListId == that.songsListId && collectorId == that.collectorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(songsListId, collectorId);
    }
}
