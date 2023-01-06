package com.voicerecorder.repository;


import com.voicerecorder.entity.PhraseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhraseRepository extends JpaRepository<PhraseEntity, Long> {


    @Query("UPDATE PhraseEntity p SET p.original = ?2, p.translation = ?3, p.exampleRecording = ?4 where p.id= ?1")
     void updatePhrase(Long id, String original, String translation, String exampleRecording);

//    @Query("SELECT TOP $1 FROM Phrase")
//     List<Phrase> getNumberOfPhrases(int number);

}
