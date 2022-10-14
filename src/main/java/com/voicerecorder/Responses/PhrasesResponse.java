package com.voicerecorder.Responses;

import org.openapitools.client.model.Phrase;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

public class PhrasesResponse {

    private List<Phrase> phrases;
    private HttpStatus status;

    public PhrasesResponse(List<Phrase> phrases, HttpStatus status) {
        this.phrases = phrases;
        this.status = status;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
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
        PhrasesResponse that = (PhrasesResponse) o;
        return Objects.equals(phrases, that.phrases) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phrases, status);
    }
}
