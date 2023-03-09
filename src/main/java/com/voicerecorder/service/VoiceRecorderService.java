package com.voicerecorder.service;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voicerecorder.entity.*;
import com.voicerecorder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Autowired
    UserPhraseCommentsRepository userPhraseCommentsRepository;

    @Autowired
    UserPhraseCountRepository userPhraseCountRepository;


    public Phrase healthCheck() {
        Phrase response = new Phrase();

        try {
            phraseRepository.saveAndFlush(new Phrase());
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

    public Phrase addPhrase(Phrase phrase) {
        return phraseRepository.saveAndFlush(phrase);
    }

    @Transactional
    public void deletePhrase(Long id) {
        //delete all userPhrases associated with Phrase
        userPhraseRepository.deleteUserPhrasesWithPhraseId(id);
        userPhraseRepository.flush();
        //delete all userPhraseComments associated with phrase
        userPhraseCommentsRepository.deleteUserPhraseCommentsWithPhraseId(id);
        userPhraseCommentsRepository.flush();
        //finally, delete phrase
        phraseRepository.deleteById(id);
        phraseRepository.flush();


    }
    @Transactional
    public void updatePhrase(Phrase phrase) {
        phraseRepository.updatePhrase(phrase.getId(), phrase.getOriginal(), phrase.getTranslation(), phrase.getExampleRecordingPath());
        phraseRepository.flush();
    }

    public Phrase getPhraseById(Long id) {
        return phraseRepository.getReferenceById(id);
    }


    public List<Phrase> getPhraseListByIds(List<Long> phraseIds) {return phraseRepository.findAllById(phraseIds);}


    //user stuff

    public User addUser(User user) {
       return userRepository.saveAndFlush(user);
    }

    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
        userRepository.flush();
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
        userRepository.flush();

    }

    @Transactional
    public void updateUser(User user) {
        userRepository.updateUser(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getProject());
        userRepository.flush();
    }

    //phrase set

    public PhraseSet addPhraseSet(PhraseSet phraseSet) {
        return phraseSetRepository.saveAndFlush(phraseSet);
    }

    public PhraseSet getPhraseSetById(Long id) {
        return phraseSetRepository.getReferenceById(id);
    }

    @Transactional
    public void deletePhraseSet(PhraseSet phraseSet) {
        phraseSetRepository.delete(phraseSet);
        phraseSetRepository.flush();
    }

    @Transactional
    public void deletePhraseSetById(Long id) {
        phraseSetRepository.deleteById(id);
        phraseSetRepository.flush();

    }

    @Transactional
    public void updatePhraseSet(PhraseSet phraseSet) {
        phraseSetRepository.updatePhraseSet(phraseSet.getId(), phraseSet.getPhraseSetName(), phraseSet.getStartDate(), phraseSet.getEndDate());
        phraseSetRepository.flush();

    }

    //UserPhrase
    public UserPhrase addUserPhrase(UserPhrase userPhrase) {
        return userPhraseRepository.saveAndFlush(userPhrase);
    }

    @Transactional
    public void updateUserPhrase(UserPhrase userPhrase) {
        userPhraseRepository.updateUserPhrase(userPhrase.getId(), userPhrase.getPhraseId(),
                userPhrase.getUserId(), userPhrase.getDateTime(), userPhrase.getFilePath());
        userPhraseRepository.flush();
    }

    public UserPhrase getUserPhraseById(Long id) {
        return userPhraseRepository.getReferenceById(id);
    }

    @Transactional
    public void deleteUserPhrase(UserPhrase userPhrase) {
        userPhraseCommentsRepository.deleteUserPhraseCommentsWithUserPhraseId(userPhrase.getId());
        userPhraseRepository.delete(userPhrase);
        userPhraseRepository.flush();

    }

    @Transactional
    public void deleteUserPhraseById(Long id) {
        userPhraseRepository.deleteById(id);
        userPhraseRepository.flush();

    }


    //UserPhraseComment

    public UserPhraseComment addUserPhraseComments(UserPhraseComment userPhraseComment) {
        return userPhraseCommentsRepository.saveAndFlush(userPhraseComment);
    }

    public UserPhraseComment getUserPhraseCommentsById(Long id) {
        return userPhraseCommentsRepository.getReferenceById(id);
    }

    @Transactional
    public void updateUserPhraseComment(UserPhraseComment userPhraseComment) {
        userPhraseCommentsRepository.updateUserPhraseComment(
                userPhraseComment.getId(),
                userPhraseComment.getPhraseId(),
                userPhraseComment.getComment(),
                userPhraseComment.getDateTime(),
                userPhraseComment.getUserId());

        userPhraseCommentsRepository.flush();
    }

    @Transactional
    public void deleteUserPhraseComments(UserPhraseComment userPhraseComment) {
        userPhraseCommentsRepository.delete(userPhraseComment);
        userPhraseCommentsRepository.flush();

    }
    @Transactional
    public void deleteUserPhraseCommentsById(Long id) {
        userPhraseCommentsRepository.deleteById(id);
        userPhraseCommentsRepository.flush();
    }

    //UserPhraseCount

    public List<UserPhraseCount> getRemainingPhrasesToRecordFromPhraseSet(Long userId, Long phraseSetId) {
        return userPhraseCountRepository.getRemainingPhrasesGivenUserIdAndPhraseSetId(userId, phraseSetId);
    }



}
