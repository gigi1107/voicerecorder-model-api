package com.voicerecorder.Responses;

import com.voicerecorder.entity.PhraseEntity;
import com.voicerecorder.entity.PhraseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

public class PhraseEntitysResponse {

    private List<PhraseEntity> PhraseEntitys;
    private HttpStatus status;

    public PhraseEntitysResponse(List<PhraseEntity> PhraseEntitys, HttpStatus status) {
        this.PhraseEntitys = PhraseEntitys;
        this.status = status;
    }

    public List<PhraseEntity> getPhraseEntitys() {
        return PhraseEntitys;
    }

    public void setPhraseEntitys(List<PhraseEntity> PhraseEntitys) {
        this.PhraseEntitys = PhraseEntitys;
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
        PhraseEntitysResponse that = (PhraseEntitysResponse) o;
        return Objects.equals(PhraseEntitys, that.PhraseEntitys) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PhraseEntitys, status);
    }
}
