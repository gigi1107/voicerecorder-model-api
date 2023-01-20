package com.voicerecorder.service;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.entity.UserPhraseWithAudioFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class S3Service {

    private static final String BUCKET_NAME = "makah-asr";

    private static AmazonS3 client = AmazonS3ClientBuilder.defaultClient();

    // # key = 'recorded/'+recording_series+'/'+phrase_id + '_' + user_id+ "_"+ datetime_now.strftime("%Y-%m-%d_%H:%M:%S")+".txt"

    public String getBucket() {
        List<Bucket> buckets = client.listBuckets();
        return buckets.get(0).getName();
    }


    public UserPhrase saveAudioFileToS3(UserPhraseWithAudioFile userPhraseWithAudioFile)
            throws SdkClientException, IOException {
        String key = "recorded/" + userPhraseWithAudioFile.getUserPhrase().getPhraseId() + "_" + userPhraseWithAudioFile.getUserPhrase().getUserId() + "_" +
                userPhraseWithAudioFile.getUserPhrase().getDateTime() + ".m4a";
        client.putObject(BUCKET_NAME, key, userPhraseWithAudioFile.getAudioFile());

        userPhraseWithAudioFile.getUserPhrase().setFilePath(key);
        return userPhraseWithAudioFile.getUserPhrase();

    }

    public byte[] getUserPhraseFromS3(String path) throws Exception {

        S3Object s3Object;
        try {
            s3Object = client.getObject(BUCKET_NAME, path);
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        S3ObjectInputStream content = s3Object.getObjectContent();
        return content.readAllBytes();
    }

}
