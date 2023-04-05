package com.voicerecorder.controller;


import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.entity.UserPhraseWithAudioFile;
import com.voicerecorder.model.response.BucketResponse;
import com.voicerecorder.service.S3Service;
import com.voicerecorder.service.VoiceRecorderService;
import io.minio.errors.*;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


@RestController
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @Autowired
    private VoiceRecorderService voiceRecorderService;

    @GetMapping("/s3")
    @ResponseBody
    public ResponseEntity<String> getS3Buckets() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
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
            if (e instanceof FileNotFoundException) {
                FileNotFoundException fileNotFoundException = (FileNotFoundException) e;
                e.printStackTrace();
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(result);

    }

    @PostMapping("/v1/file/s3")
    @ResponseBody
    public ResponseEntity<String> getFileFromBucket(@RequestBody String keypath) {
        byte[] response;
        try {
            System.out.println("trying to fetch file from s3");
             response = s3Service.getUserPhraseFromS3(keypath);

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
