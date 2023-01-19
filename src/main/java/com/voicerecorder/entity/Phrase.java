package com.voicerecorder.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "phrases")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phrase extends VoiceRecorderObject  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phrases_SEQ")
    @SequenceGenerator(name = "phrases_SEQ", sequenceName = "phrases_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "phrase_set_id")
    private Long phraseSetId;

    @Column(name = "phrase")
    private String original;

    @Column(name = "english")
    private String translation;

    @Column(name = "example_path")
    private String exampleRecordingPath;

    public Phrase(Long phraseSetId, String original, String translation, String exampleRecordingPath) {
        this.phraseSetId = phraseSetId;
        this.original = original;
        this.translation = translation;
        this.exampleRecordingPath = exampleRecordingPath;
    }

    public Phrase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExampleRecordingPath() {
        return exampleRecordingPath;
    }

    public void setExampleRecordingPath(String exampleRecordingPath) {
        this.exampleRecordingPath = exampleRecordingPath;
    }

    public Long getPhraseSetId() {
        return phraseSetId;
    }

    public void setPhraseSetId(Long phraseSetId) {
        this.phraseSetId = phraseSetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phrase)) return false;
        Phrase that = (Phrase) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPhraseSetId(), that.getPhraseSetId()) &&
                Objects.equals(getOriginal(), that.getOriginal()) &&
                Objects.equals(getTranslation(), that.getTranslation()) &&
                Objects.equals(getExampleRecordingPath(), that.getExampleRecordingPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhraseSetId(), getOriginal(), getTranslation(), getExampleRecordingPath());
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "id=" + id +
                ", phraseSetId=" + phraseSetId +
                ", original='" + original + '\'' +
                ", translation='" + translation + '\'' +
                ", exampleRecordingPath='" + exampleRecordingPath + '\'' +
                '}';
    }
}
