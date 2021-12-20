package com.music.followservice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "follower", schema = "TJMusic", catalog = "")
@IdClass(FollowerEntityPK.class)
public class FollowerEntity {
    private int focusId;
    private int fansId;

    @Id
    @Column(name = "focus_id")
    public int getFocusId() {
        return focusId;
    }

    public void setFocusId(int focusId) {
        this.focusId = focusId;
    }

    @Id
    @Column(name = "fans_id")
    public int getFansId() {
        return fansId;
    }

    public void setFansId(int fansId) {
        this.fansId = fansId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowerEntity that = (FollowerEntity) o;
        return focusId == that.focusId && fansId == that.fansId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(focusId, fansId);
    }
}
