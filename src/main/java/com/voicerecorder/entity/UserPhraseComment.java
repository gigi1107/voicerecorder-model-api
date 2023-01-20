package com.voicerecorder.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_phrase_comments")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserPhraseComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_phrase_comments_id_seq")
    @SequenceGenerator(name = "user_phrase_comments_id_seq", sequenceName = "user_phrase_comments_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "phrase_id")
    Long phraseId;

    @Column(name = "comment")
    String comment;

    @Column(name = "date_time")
    Date dateTime;

    @Column(name = "user_id")
    Long userId;

    public UserPhraseComment(Long phraseId, String comment, Date dateTime, Long userId) {
        this.phraseId = phraseId;
        this.comment = comment;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public UserPhraseComment(Long id, Long phraseId, String comment, Date dateTime, Long userId) {
        this.id = id;
        this.phraseId = phraseId;
        this.comment = comment;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public UserPhraseComment() {
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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
        if (!(o instanceof UserPhraseComment)) return false;
        UserPhraseComment that = (UserPhraseComment) o;
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
        return "UserPhraseComment{" +
                "id=" + id +
                ", phraseId=" + phraseId +
                ", comment='" + comment + '\'' +
                ", dateTime=" + dateTime +
                ", userId=" + userId +
                '}';
    }
}
