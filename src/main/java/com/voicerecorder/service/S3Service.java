package com.voicerecorder.service;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.github.psambit9791.wavfile.WavFile;
import com.voicerecorder.entity.UserPhrase;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;


public class S3Service {

    public static final String BUCKET_NAME = "makah-asr";

    public static AmazonS3 client = AmazonS3ClientBuilder.defaultClient();

    // # key = 'recorded/'+recording_series+'/'+phrase_id + '_' + user_id+ "_"+ datetime_now.strftime("%Y-%m-%d_%H:%M:%S")+".txt"
    public UserPhrase saveAudioFileToS3(UserPhrase userPhrase, File audioFile)
            throws SdkClientException, IOException {
        String key = "recorded/" + userPhrase.getPhraseId() + "_" + userPhrase.getUserId() + "_" + userPhrase.getDateTime();
        client.putObject(BUCKET_NAME, key, audioFile);

        userPhrase.setFilePath(key);
        return userPhrase;

    }

    public byte[] getUserPhraseFromS3(String path) throws Exception {

        S3Object s3Object = client.getObject(BUCKET_NAME, path);
        S3ObjectInputStream content = s3Object.getObjectContent();
        return content.readAllBytes();
    }

}
