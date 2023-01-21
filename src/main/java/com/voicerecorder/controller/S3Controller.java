package com.voicerecorder.controller;


import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.entity.UserPhraseWithAudioFile;
import com.voicerecorder.service.S3Service;
import com.voicerecorder.service.VoiceRecorderService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
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

    // POSTCONDITION: Client must also call updateUserPhrase with the proper Fi
    // le path from the return value.
    @PostMapping("/v1/userPhrase/s3")
    @ResponseBody
    public ResponseEntity<UserPhrase> saveAudioFileToS3(@RequestBody UserPhraseWithAudioFile userPhraseWithAudioFile) {
        UserPhrase result;
        try {
            result = s3Service.saveAudioFileToS3(userPhraseWithAudioFile);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(result);

    }

    @PostMapping("/v1/file/s3")
    @ResponseBody
    public ResponseEntity<List<Byte>> getFileFromS3(@RequestBody String keypath) {
        byte[] bytes;
        try {
            System.out.println("trying to fetch file from s3");
             bytes = s3Service.getUserPhraseFromS3(keypath);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        List<Byte> list = Arrays.asList(ArrayUtils.toObject(bytes));
        return ResponseEntity.ok(list);
    }

}
