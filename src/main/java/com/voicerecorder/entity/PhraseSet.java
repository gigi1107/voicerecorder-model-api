package com.voicerecorder.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;



@Entity
@Table(name = "phrase_sets")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PhraseSet  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "collection_sets_id_seq")
    @SequenceGenerator(name = "collection_sets_id_seq", sequenceName = "collection_sets_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "phrase_set_name")
    private String phraseSetName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    public PhraseSet(String phraseSetName, Date startDate, Date endDate) {
        this.phraseSetName = phraseSetName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PhraseSet(Long id, String phraseSetName, Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
