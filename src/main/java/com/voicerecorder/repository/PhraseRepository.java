package com.voicerecorder.repository;


import com.voicerecorder.entity.PhraseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhraseRepository extends JpaRepository<PhraseEntity, Long> {

//
//    @Query("UPDATE phrases p SET p.phrase=$2, p.english=$3, p.example_path=$4 where p.id= ?1")
//     void updatePhrase(Long id, String original, String translation, String exampleRecording);

//    @Query("SELECT TOP $1 FROM Phrase")
//     List<Phrase> getNumberOfPhrases(int number);

}
