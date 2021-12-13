package com.example.tjmusic.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "songslist_collector", schema = "TJMusic", catalog = "")
@IdClass(SongslistCollectorEntityPK.class)
public class SongslistCollectorEntity {
    private int songsListId;
    private int collectorId;

    @Id
    @Column(name = "songs_list_id")
    public int getSongsListId() {
        return songsListId;
    }

    public void setSongsListId(int songsListId) {
        this.songsListId = songsListId;
    }

    @Id
    @Column(name = "collector_id")
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
        SongslistCollectorEntity that = (SongslistCollectorEntity) o;
        return songsListId == that.songsListId && collectorId == that.collectorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(songsListId, collectorId);
    }
}
