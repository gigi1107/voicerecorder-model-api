package com.voicerecorder.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name = "user_phrases")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserPhrase extends VoiceRecorderObject  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_phrases_id_seq")
    @SequenceGenerator(name = "user_phrases_id_seq", sequenceName = "user_phrases_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "phrase_id")
    private Long phraseId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "file_path")
    private String filePath;

    public UserPhrase(Long phraseId, Long userId, Date dateTime, String filePath) {
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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
