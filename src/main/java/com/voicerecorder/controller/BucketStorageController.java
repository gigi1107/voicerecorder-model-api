package com.voicerecorder.controller;


import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.entity.UserPhraseWithAudioFile;
import com.voicerecorder.service.BucketStorageService;
import com.voicerecorder.service.VoiceRecorderService;
import io.minio.errors.*;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.Arrays;


@RestController
public class BucketStorageController {

    @Autowired
    private BucketStorageService bucketStorageService;

    @Autowired
    private VoiceRecorderService voiceRecorderService;

    // POSTCONDITION: Client must also call updateUserPhrase with the proper Fi
    // le path from the return value.
    @PostMapping("/v1/file")
    @ResponseBody
    public ResponseEntity<UserPhrase> saveAudioFileToBucket(@RequestBody UserPhraseWithAudioFile userPhraseWithAudioFile) {
        UserPhrase result;
        try {
            result = bucketStorageService.saveAudioFileToBucket(userPhraseWithAudioFile);

        } catch (Exception e ) {
            if (e instanceof FileNotFoundException) {
                FileNotFoundException fileNotFoundException = (FileNotFoundException) e;
                e.printStackTrace();
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(result);

    }

    @PostMapping("/v1/file/get")
    @ResponseBody
    public ResponseEntity<String> getFileFromBucket(@RequestBody String keypath) {
        byte[] response;
        try {
            System.out.println("trying to fetch file from bucket");
             response = bucketStorageService.getUserPhraseFromBucket(keypath);

        } catch (Exception e ) {
            if(e instanceof  ErrorResponseException) {
                ErrorResponseException errorResponseException = (ErrorResponseException) e;
                Response response1 = errorResponseException.response();
                return ResponseEntity.status(response1.code()).body(errorResponseException.getMessage());
            }
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().body(Arrays.toString(response));
    }

}
