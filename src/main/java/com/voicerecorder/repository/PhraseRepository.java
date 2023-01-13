package com.voicerecorder.repository;


import com.voicerecorder.entity.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {


    @Query("UPDATE Phrase p SET p.original = ?2, p.translation = ?3, p.exampleRecordingPath = ?4 where p.id= ?1")
     Phrase updatePhrase(Long id, String original, String translation, String exampleRecordingPath);

//    @Query("SELECT TOP $1 FROM Phrase")
//     List<Phrase> getNumberOfPhrases(int number);

}
