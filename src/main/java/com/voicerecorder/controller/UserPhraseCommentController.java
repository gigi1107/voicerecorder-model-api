package com.voicerecorder.controller;

import com.voicerecorder.entity.UserPhraseComment;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserPhraseCommentController {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;


    @PostMapping("/v1/userPhraseComment")
    @ResponseBody
    public ResponseEntity<UserPhraseComment> adduserPhraseComments(@RequestBody UserPhraseComment userPhraseComment) {
        UserPhraseComment response;
        try {
            response = voiceRecorderService.addUserPhraseComments(userPhraseComment);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(response);

    }

    @PutMapping("/v1/userPhraseComment")
    @ResponseBody
    public ResponseEntity<String> updateUserPhraseComment(@RequestBody UserPhraseComment userPhraseComment) {
        try {
            voiceRecorderService.updateUserPhraseComment(userPhraseComment);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Success");

    }

    @PostMapping("/v1/userPhraseComment/{userPhraseCommentId}")
    public ResponseEntity<UserPhraseComment> getUserPhraseCommentsById(@PathVariable Long userPhraseCommentId) {
        UserPhraseComment userPhraseComment;

        try {
            userPhraseComment = voiceRecorderService.getUserPhraseCommentsById(userPhraseCommentId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(userPhraseComment);

    }

    @DeleteMapping("/v1/userPhraseComment/{userPhraseCommentId}")
    public ResponseEntity<Void> deleteUserPhraseCommentsById(@PathVariable String userPhraseCommentId) {
        try {
            Long id = Long.parseLong(userPhraseCommentId);
            voiceRecorderService.deleteUserPhraseCommentsById(id);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/v1/userPhraseComment")
    public ResponseEntity<Void> deleteUserPhraseComments(@RequestBody UserPhraseComment userPhraseComment) {
        try {
            voiceRecorderService.deleteUserPhraseComments(userPhraseComment);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }


}
