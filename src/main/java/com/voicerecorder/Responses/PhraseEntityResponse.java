package com.voicerecorder.Responses;

import com.voicerecorder.entity.PhraseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

public class PhraseEntityResponse {

    private List<PhraseEntity> phraseEntityList;
    private HttpStatus status;

    public PhraseEntityResponse(List<PhraseEntity> phraseEntityList, HttpStatus status) {
        this.phraseEntityList = phraseEntityList;
        this.status = status;
    }

    public List<PhraseEntity> getPhraseEntityList() {
        return phraseEntityList;
    }

    public void setPhraseEntityList(List<PhraseEntity> PhraseEntitys) {
        this.phraseEntityList = PhraseEntitys;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhraseEntityResponse that = (PhraseEntityResponse) o;
        return Objects.equals(phraseEntityList, that.phraseEntityList) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phraseEntityList, status);
    }
}
