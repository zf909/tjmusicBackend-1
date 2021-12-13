package com.music.followservice.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FollowerEntityPK implements Serializable {
    private int focusId;
    private int fansId;

    @Column(name = "focus_id")
    @Id
    public int getFocusId() {
        return focusId;
    }

    public void setFocusId(int focusId) {
        this.focusId = focusId;
    }

    @Column(name = "fans_id")
    @Id
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
        FollowerEntityPK that = (FollowerEntityPK) o;
        return focusId == that.focusId && fansId == that.fansId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(focusId, fansId);
    }
}
