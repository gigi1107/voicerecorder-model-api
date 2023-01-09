package com.voicerecorder.service;


import com.voicerecorder.entity.Phrase;
import com.voicerecorder.entity.PhraseSet;
import com.voicerecorder.entity.User;
import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.repository.PhraseRepository;
import com.voicerecorder.repository.PhraseSetRepository;
import com.voicerecorder.repository.UserPhraseRepository;
import com.voicerecorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;


@org.springframework.stereotype.Service
public class VoiceRecorderService {

    @Autowired
    private PhraseRepository phraseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PhraseSetRepository phraseSetRepository;

    @Autowired
    UserPhraseRepository userPhraseRepository;


    public Phrase healthCheck() {
        Phrase response = new Phrase();

        try {
            phraseRepository.save(new Phrase());
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

    public void addPhrase(Phrase phrase) {
        phraseRepository.save(phrase);
    }

    public void deletePhrase(Long id) {
        phraseRepository.deleteById(id);
    }

    public void updatePhrase(Phrase phrase) {
        phraseRepository.updatePhrase(phrase.getId(), phrase.getOriginal(), phrase.getTranslation(), phrase.getExampleRecording());
    }

    public Phrase getPhraseById(Long id) {
        return phraseRepository.getReferenceById(id);
    }

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

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteUserById(Long id) { userRepository.deleteById(id);}

    public void updateUser(User user) {
        userRepository.updateUser(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getProject());
    }

    //phrase set

    public void addPhraseSet(PhraseSet phraseSet) {
        phraseSetRepository.save(phraseSet);
    }

    public PhraseSet getPhraseSetById(Long id) {
        return phraseSetRepository.getReferenceById(id);
    }

    public void deletePhraseSet(PhraseSet phraseSet) {
        phraseSetRepository.delete(phraseSet);
    }

    public void deletePhraseSetById(Long id) { phraseSetRepository.deleteById(id);}

    public void updatePhraseSet(PhraseSet phraseSet) {
        phraseSetRepository.updatePhraseSet(phraseSet.getId(), phraseSet.getPhraseSetName(), phraseSet.getStartDate(), phraseSet.getEndDate());
    }

    //UserPhrase
    public void addUserPhrase(UserPhrase userPhrase) {
        userPhraseRepository.save(userPhrase);
    }

    public UserPhrase getUserPhraseById(Long id) {
        return userPhraseRepository.getReferenceById(id);
    }

    public void deleteUserPhrase(UserPhrase phraseSet) {
        userPhraseRepository.delete(phraseSet);
    }

    public void deleteUserPhraseById(Long id) { userPhraseRepository.deleteById(id);}


    }
