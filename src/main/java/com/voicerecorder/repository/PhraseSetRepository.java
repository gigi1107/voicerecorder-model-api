package com.voicerecorder.repository;

import com.voicerecorder.entity.PhraseSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface PhraseSetRepository extends JpaRepository<PhraseSet, Long> {

//
//    @Id
//    private Long id;
//
//    @Column(name = "phrase_set_name")
//    private String phraseSetName;
//
//    @Column(name = "start_date")
//    private Timestamp startDate;
//
//    @Column(name = "end_date")
//    private Timestamp endDate;

    @Query("UPDATE PhraseSet p SET p.phraseSetName = ?2, p.startDate = ?3, p.endDate = ?4 where p.id= ?1")
    void updatePhraseSet(Long id, String phraseSetName, Timestamp startDate, Timestamp endDate);
}
