package com.voicerecorder.controller;


import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;


@Controller
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/v1/userPhrase/s3")
    @ResponseBody
    public ResponseEntity<UserPhrase> saveAudioFileToS3(@RequestBody UserPhrase userPhrase, @RequestBody File audioFile) {
        try {
            s3Service.saveAudioFileToS3(userPhrase, audioFile);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

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
