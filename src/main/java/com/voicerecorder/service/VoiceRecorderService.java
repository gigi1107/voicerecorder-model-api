package com.voicerecorder.service;


import com.voicerecorder.EntityModels.PhraseEntity;
import com.voicerecorder.Responses.PhrasesResponse;
import com.voicerecorder.repository.PhraseRepository;
import com.voicerecorder.repository.UserRepository;
import org.openapitools.client.model.Phrase;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class VoiceRecorderService {

    private PhraseRepository phraseRepository;

    private UserRepository userRepository;

    //phrase stuff

    public void addPhrase(PhraseEntity phrase) {
        phraseRepository.save(phrase);
    }

    public void deletePhrase(Long id) {
        phraseRepository.deleteById(id);
    }

    public void updatePhrase(PhraseEntity phraseEntity) {
        phraseRepository.updatePhrase(phraseEntity.getId(), phraseEntity.getOriginal(), phraseEntity.getTranslation(), phraseEntity.getExampleRecording());
    }

    //todo implement some logic so that it's not just the same phrases over and over
    public PhrasesResponse getPhrases (int number) {
        List<PhraseEntity> phraseEntities =  phraseRepository.getNumberOfPhrases(number);
        List<Phrase> phrases = new ArrayList<>();
        phrases.addAll(phraseEntities);

        return new PhrasesResponse(phrases, HttpStatus.OK);
    }


    //user stuff


}
