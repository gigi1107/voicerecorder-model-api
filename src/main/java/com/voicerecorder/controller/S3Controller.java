package com.voicerecorder.controller;


import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.service.S3Service;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;


@Controller
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @Autowired
    private VoiceRecorderService voiceRecorderService;

    @GetMapping("/s3")
    @ResponseBody
    public ResponseEntity<String> getS3Buckets() {
        String result = s3Service.getBucket();
        return ResponseEntity.ok(result);
    }

    // POSTCONDITION: Client must also call updateUserPhrase with the proper File path from the return value.
    @PostMapping("/v1/userPhrase/s3")
    @ResponseBody
    public ResponseEntity<UserPhrase> saveAudioFileToS3(@RequestBody UserPhrase userPhrase, @RequestBody File audioFile) {
        UserPhrase result;
        try {
            result = s3Service.saveAudioFileToS3(userPhrase, audioFile);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(result);

    }

    @PostMapping("/v1/userPhrase/s3/{keypath}")
    @ResponseBody
    public ResponseEntity<UserPhrase> getUserPhraseFromS3(@RequestParam String keypath) {
        try {
            byte[] bytes = s3Service.getUserPhraseFromS3(keypath);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

}
