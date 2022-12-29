package com.voicerecorder.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Entity
@Table(name = "phrases")
@Data
public class PhraseEntity implements Serializable {

    @Id
    private Long id;

    @Column(name = "phrase_set_id")
    private Long phraseSetId;

    @Column(name = "phrase")
    private String original;

    @Column(name = "english")
    private String translation;

    @Column(name = "example_path")
    private String exampleRecording;

    public PhraseEntity(Long id, Long phraseSetId, String original, String translation, String exampleRecording) {
        this.id = id;
        this.phraseSetId = phraseSetId;
        this.original = original;
        this.translation = translation;
        this.exampleRecording = exampleRecording;
    }

    public PhraseEntity() {
    }

    public PhraseEntity(Long phraseSetId, String original, String translation, String exampleRecording) {
        this.phraseSetId = phraseSetId;
        this.original = original;
        this.translation = translation;
        this.exampleRecording = exampleRecording;
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

    public String getExampleRecording() {
        return exampleRecording;
    }

    public void setExampleRecording(String exampleRecording) {
        this.exampleRecording = exampleRecording;
    }

    public Long getPhraseSetId() {
        return phraseSetId;
    }

    public void setPhraseSetId(Long phraseSetId) {
        this.phraseSetId = phraseSetId;
    }
}
