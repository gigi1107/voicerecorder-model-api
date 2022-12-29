package com.voicerecorder.service;


import com.voicerecorder.entity.PhraseEntity;
import com.voicerecorder.entity.UserEntity;
import com.voicerecorder.repository.PhraseRepository;
import com.voicerecorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;


@org.springframework.stereotype.Service
public class VoiceRecorderService {

    @Autowired
    private PhraseRepository phraseRepository;

    @Autowired
    private UserRepository userRepository;

    public PhraseEntity healthCheck() {
        PhraseEntity response = new PhraseEntity();

        try {
            phraseRepository.save(new PhraseEntity());
//            response = phraseRepository.getReferenceById(1L);
        } catch (Exception e) {
            System.out.println("There was an error");
            System.out.println(e.getMessage());
//            for(StackTraceElement el : e.getStackTrace()) {
//                System.out.println(el.toString());
//            }

        }
        return response;
    }

    //phrase stuff

    public void addPhrase(PhraseEntity phrase) {
        phraseRepository.save(phrase);
    }

    public void deletePhrase(Long id) {
        phraseRepository.deleteById(id);
    }

//    public void updatePhrase(PhraseEntity Phrase) {
////        phraseRepository.updatePhrase(Phrase.getId(), Phrase.getOriginal(), Phrase.getTranslation(), Phrase.getExampleRecording());
//    }

//    //todo implement some logic so that it's not just the same phrases over and over
//    public PhrasesResponse getPhrases (int number) {
//        List<Phrase> phraseEntities =  phraseRepository.getNumberOfPhrases(number);
//        List<Phrase> phrases = new ArrayList<>();
//        phrases.addAll(phraseEntities);
//
//        return new PhrasesResponse(phrases, HttpStatus.OK);
//    }
//

    //user stuff

    public void addUser(UserEntity user) {
        userRepository.save(user);
    }

    public void deleteUser(UserEntity user) {
        userRepository.delete(user);
    }

//    public void updateUser(UserEntity user) {
////        userRepository.updateUser(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getProject());
//    }


}
