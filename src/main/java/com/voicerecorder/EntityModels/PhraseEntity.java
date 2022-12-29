package com.voicerecorder.EntityModels;


import org.openapitools.client.model.Phrase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhraseEntity extends Phrase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String original;
    private String translation;
    private String exampleRecording;


    public PhraseEntity(Long id, String original, String translation, String exampleRecording) {
        this.id = id;
        this.original = original;
        this.translation = translation;
        this.exampleRecording = exampleRecording;
    }

    public PhraseEntity() {}

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

    @Override
    public String toString() {
        return "PhraseEntity{" +
                "id=" + id +
                ", original='" + original + '\'' +
                ", translation='" + translation + '\'' +
                ", exampleRecording='" + exampleRecording + '\'' +
                '}';
    }


}
