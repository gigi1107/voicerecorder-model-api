package com.voicerecorder.controller;

import com.voicerecorder.entity.User;
import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserPhraseController {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;


    @PostMapping("/v1/userPhrase")
    @ResponseBody
    public ResponseEntity<String> addUserPhrase(@RequestBody UserPhrase userPhrase) {
        try {
            voiceRecorderService.addUserPhrase(userPhrase);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Success");

    }

    @PostMapping("/v1/userPhrase/{userPhraseId}")
    public ResponseEntity<UserPhrase> getUserPhraseById(@PathVariable Long userPhraseId) {
        UserPhrase userPhrase;

        try {
            userPhrase = voiceRecorderService.getUserPhraseById(userPhraseId);
        }
        catch (Exception e) {
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
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/v1/userPhrae")
    public ResponseEntity<Void> deleteUserPhrase(@RequestBody UserPhrase userPhrase) {
        try {
            voiceRecorderService.deleteUserPhrase(userPhrase);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }



}
