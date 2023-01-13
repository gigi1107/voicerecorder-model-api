package com.voicerecorder.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;


// Shouldn't phrase sets correspond somehow with phrases?

@Entity
@Table(name = "phrase_sets")
@Data
public class PhraseSet implements Serializable {

    @Id
    private Long id;

    @Column(name = "phrase_set_name")
    private String phraseSetName;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    public PhraseSet(Long id, String phraseSetName, String startDate, String endDate) {
        this.id = id;
        this.phraseSetName = phraseSetName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PhraseSet() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhraseSetName() {
        return phraseSetName;
    }

    public void setPhraseSetName(String phraseSetName) {
        this.phraseSetName = phraseSetName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhraseSet)) return false;
        PhraseSet that = (PhraseSet) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPhraseSetName(), that.getPhraseSetName()) &&
                Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(getEndDate(), that.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPhraseSetName(), getStartDate(), getEndDate());
    }

    @Override
    public String toString() {
        return "PhraseSet{" +
                "id=" + id +
                ", phraseSetName='" + phraseSetName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
