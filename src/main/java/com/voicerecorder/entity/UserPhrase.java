package com.voicerecorder.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Objects;


@Entity
@Table(name = "user_phrases")
@Data
public class UserPhrase {
    @Id
    private Long id;

    @Column(name = "phrase_id")
    private Long phraseId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "file_path")
    private String filePath;

    public UserPhrase(Long id, Long phraseId, Long userId, String dateTime, String filePath) {
        this.id = id;
        this.phraseId = phraseId;
        this.userId = userId;
        this.dateTime = dateTime;
        this.filePath = filePath;
    }

    public UserPhrase() {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPhrase)) return false;
        UserPhrase that = (UserPhrase) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPhraseId(), that.getPhraseId()) &&
                Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getDateTime(), that.getDateTime()) &&
                Objects.equals(getFilePath(), that.getFilePath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhraseId(), getUserId(), getDateTime(), getFilePath());
    }

    @Override
    public String toString() {
        return "UserPhrase{" +
                "id=" + id +
                ", phraseId=" + phraseId +
                ", userId=" + userId +
                ", dateTime=" + dateTime +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
