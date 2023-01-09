package com.voicerecorder.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_phrase_comments")
@Data
public class UserPhraseComments implements Serializable {
    @Id
    private Long id;

    @Column(name = "phrase_id")
    Long phraseId;

    @Column(name = "comment")
    String comment;

    @Column(name = "date_time")
    Timestamp dateTime;

    @Column(name = "user_id")
    Long userId;

    public UserPhraseComments(Long id, Long phraseId, String comment, Timestamp dateTime, Long userId) {
        this.id = id;
        this.phraseId = phraseId;
        this.comment = comment;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public UserPhraseComments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhraseId() {
        return phraseId;
    }

    public void setPhraseId(Long phraseId) {
        this.phraseId = phraseId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPhraseComments)) return false;
        UserPhraseComments that = (UserPhraseComments) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPhraseId(), that.getPhraseId()) &&
                Objects.equals(getComment(), that.getComment()) &&
                Objects.equals(getDateTime(), that.getDateTime()) &&
                Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhraseId(), getComment(), getDateTime(), getUserId());
    }

    @Override
    public String toString() {
        return "UserPhraseComments{" +
                "id=" + id +
                ", phraseId=" + phraseId +
                ", comment='" + comment + '\'' +
                ", dateTime=" + dateTime +
                ", userId=" + userId +
                '}';
    }
}
