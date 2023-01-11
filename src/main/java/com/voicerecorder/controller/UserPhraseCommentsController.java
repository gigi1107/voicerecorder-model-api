package com.voicerecorder.controller;

import com.voicerecorder.entity.UserPhraseComments;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserPhraseCommentsController {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;


    @PostMapping("/v1/userPhraseComments")
    @ResponseBody
    public ResponseEntity<String> adduserPhraseComments(@RequestBody UserPhraseComments userPhraseComments) {
        try {
            voiceRecorderService.addUserPhraseComments(userPhraseComments);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Success");

    }

    @PostMapping("/v1/userPhraseComments/{userPhraseCommentsId}")
    public ResponseEntity<UserPhraseComments> getuserPhraseCommentsById(@PathVariable Long userPhraseCommentsId) {
        UserPhraseComments userPhraseComments;

        try {
            userPhraseComments = voiceRecorderService.getUserPhraseCommentsById(userPhraseCommentsId);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(userPhraseComments);

    }

    @DeleteMapping("/v1/userPhraseComments/{userPhraseCommentsId}")
    public ResponseEntity<Void> deleteuserPhraseCommentsById(@PathVariable String userPhraseCommentsId) {
        try {
            Long id = Long.parseLong(userPhraseCommentsId);
            voiceRecorderService.deleteUserPhraseCommentsById(id);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/v1/userPhraseComments")
    public ResponseEntity<Void> deleteuserPhraseComments(@RequestBody UserPhraseComments userPhraseComments) {
        try {
            voiceRecorderService.deleteUserPhraseComments(userPhraseComments);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }


}
