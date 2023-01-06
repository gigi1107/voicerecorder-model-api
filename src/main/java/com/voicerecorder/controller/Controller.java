package com.voicerecorder.controller;


import com.voicerecorder.Responses.PhraseEntityResponse;
import com.voicerecorder.entity.PhraseEntity;
import com.voicerecorder.entity.UserEntity;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;

    @GetMapping("/ping")
    public ResponseEntity<PhraseEntity> ping() {

        PhraseEntity response = voiceRecorderService.healthCheck();

        if (response != null) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.internalServerError().body(null);
    }


    @PostMapping("/v1/phrase")
    @ResponseBody
    public ResponseEntity<Void> addPhrase(@RequestBody PhraseEntity phrase) {
        try {
            voiceRecorderService.addPhrase(phrase);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

    @PostMapping("/v1/phrase/{phraseId}")
    public ResponseEntity<PhraseEntity> getPhraseById(@PathVariable Long phraseId) {
        PhraseEntity phraseEntity;

        try {
            phraseEntity = voiceRecorderService.getPhraseById(phraseId);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(phraseEntity);

    }

    @PutMapping("/v1/phrase")
    public ResponseEntity<Void> updatePhrase(@RequestBody PhraseEntity phrase) {
        try {
            voiceRecorderService.updatePhrase(phrase);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/phrase/{phraseId}")
    public ResponseEntity<Void> deletePhrase(@PathVariable String phraseId) {
        try {
            Long id = Long.parseLong(phraseId);
            voiceRecorderService.deletePhrase(id);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }





    ////// USER

    @PostMapping("/v1/user")
    @ResponseBody
    public ResponseEntity<String> addUser(@RequestBody UserEntity userEntity) {
        try {
            voiceRecorderService.addUser(userEntity);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Success");

    }

    @PostMapping("/v1/user/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long userId) {
        UserEntity userEntity;

        try {
            userEntity = voiceRecorderService.getUserById(userId);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(userEntity);

    }

    @PutMapping("/v1/user")
    public ResponseEntity<Void> updateUser(@RequestBody UserEntity userEntity) {
        try {
            voiceRecorderService.updateUser(userEntity);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/user/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String userId) {
        try {
            Long id = Long.parseLong(userId);
            voiceRecorderService.deleteUserById(id);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/v1/user")
    public ResponseEntity<Void> deleteUser(@RequestBody UserEntity userEntity) {
        try {
            voiceRecorderService.deleteUser(userEntity);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }




}
