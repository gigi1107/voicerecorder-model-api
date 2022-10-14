package com.voicerecorder.repository;


import com.voicerecorder.EntityModels.PhraseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhraseRepository extends CrudRepository<PhraseEntity, Long> {


    @Query("UPDATE PhraseEntity p SET original=$2, translation=$3, exampleRecording=$4 where p.id= ?1")
    public void updatePhrase(Long id, String original, String translation, String exampleRecording);

    @Query("SELECT TOP $1 FROM PhraseEntity")
    public List<PhraseEntity> getNumberOfPhrases(int number);

}
