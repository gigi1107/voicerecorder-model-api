package com.voicerecorder.controller;

import com.voicerecorder.entity.UserPhraseComment;
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


    @PostMapping("/v1/userPhraseComment")
    @ResponseBody
    public ResponseEntity<String> adduserPhraseComments(@RequestBody UserPhraseComment userPhraseComment) {
        try {
            voiceRecorderService.addUserPhraseComments(userPhraseComment);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Success");

    }

    @PostMapping("/v1/userPhraseComments/{userPhraseCommentsId}")
    public ResponseEntity<UserPhraseComment> getuserPhraseCommentsById(@PathVariable Long userPhraseCommentsId) {
        UserPhraseComment userPhraseComment;

        try {
            userPhraseComment = voiceRecorderService.getUserPhraseCommentsById(userPhraseCommentsId);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(userPhraseComment);

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

    @DeleteMapping("/v1/userPhraseComment")
    public ResponseEntity<Void> deleteuserPhraseComments(@RequestBody UserPhraseComment userPhraseComment) {
        try {
            voiceRecorderService.deleteUserPhraseComments(userPhraseComment);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }


}
