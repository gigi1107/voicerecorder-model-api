package com.voicerecorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_phrase_count")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserPhraseCount implements Serializable {

    @Id
    Long id;
////    user_id | phrase_id | phrase_set_id | c
    @Column(name = "user_id")
    Long userId;

    @Column(name = "phrase_id")
    Long phraseId;

    @Column(name = "phrase_set_id")
    Long phraseSetId;

    @Column(name = "c")
    Integer count;

    public UserPhraseCount(Long userId, Long phraseId, Long phraseSetId, Integer count) {
        this.userId = userId;
        this.phraseId = phraseId;
        this.phraseSetId = phraseSetId;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPhraseCount that)) return false;
        return Objects.equals(userId, that.userId) && Objects.equals(phraseId, that.phraseId) && Objects.equals(phraseSetId, that.phraseSetId) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, phraseId, phraseSetId, count);
    }

    @Override
    public String toString() {
        return "UserPhraseCount{" +
                "userId=" + userId +
                ", phraseId=" + phraseId +
                ", phraseSetId=" + phraseSetId +
                ", count=" + count +
                '}';
    }
}
