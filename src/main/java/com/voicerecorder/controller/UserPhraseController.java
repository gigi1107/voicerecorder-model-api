package com.voicerecorder.controller;

import com.voicerecorder.entity.User;
import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserPhraseController {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;


    @PostMapping("/v1/userPhrase")
    @ResponseBody
    public ResponseEntity<UserPhrase> addUserPhrase(@RequestBody UserPhrase userPhrase) {
        UserPhrase response;
        try {
            response = voiceRecorderService.addUserPhrase(userPhrase);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(response);

    }

    @PutMapping("/v1/userPhrase")
    @ResponseBody
    public ResponseEntity<Void> updateUserPhrase(@RequestBody UserPhrase userPhrase) {
        try {
            voiceRecorderService.updateUserPhrase(userPhrase);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

    @PostMapping("/v1/userPhrase/{userPhraseId}")
    public ResponseEntity<UserPhrase> getUserPhraseById(@PathVariable Long userPhraseId) {
        UserPhrase userPhrase;

        try {
            userPhrase = voiceRecorderService.getUserPhraseById(userPhraseId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(userPhrase);

    }

    @DeleteMapping("/v1/userPhrase/{userPhraseId}")
    public ResponseEntity<Void> deleteUserPhraseById(@PathVariable String userPhraseId) {
        try {
            Long id = Long.parseLong(userPhraseId);
            voiceRecorderService.deleteUserById(id);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/v1/userPhrase")
    public ResponseEntity<Void> deleteUserPhrase(@RequestBody UserPhrase userPhrase) {
        try {
            voiceRecorderService.deleteUserPhrase(userPhrase);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }



}
