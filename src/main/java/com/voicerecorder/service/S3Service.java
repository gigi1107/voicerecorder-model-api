package com.voicerecorder.service;

import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.entity.UserPhraseWithAudioFile;
import com.voicerecorder.model.response.BucketResponse;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import org.springframework.stereotype.Service;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class S3Service {

    private static final String BUCKET_NAME = "makah-asr";

    MinioClient minioClient =
            MinioClient.builder()
                    .endpoint("http://minio:9000")
                    .credentials("user", "password")
                    .build();

    // # key = 'recorded/'+recording_series+'/'+phrase_id + '_' + user_id+ "_"+ datetime_now.strftime("%Y-%m-%d_%H:%M:%S")+".txt"

    public String getBucket() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        List<Bucket> buckets = minioClient.listBuckets();
        return buckets.get(0).name();
    }


    public UserPhrase saveAudioFileToS3(UserPhraseWithAudioFile userPhraseWithAudioFile)
            throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        String key = "recorded/" + userPhraseWithAudioFile.getUserPhrase().getPhraseId() + "_" + userPhraseWithAudioFile.getUserPhrase().getUserId() + "_" +
                userPhraseWithAudioFile.getUserPhrase().getDateTime() + ".m4a";
        final InputStream targetStream =
                new DataInputStream(new FileInputStream(userPhraseWithAudioFile.getAudioFile()));
        PutObjectArgs putObjectArgs = PutObjectArgs.builder().bucket(BUCKET_NAME).object(key).stream(targetStream, -1, 10485760).build();
        minioClient.putObject(putObjectArgs);

        userPhraseWithAudioFile.getUserPhrase().setFilePath(key);
        return userPhraseWithAudioFile.getUserPhrase();

    }

    public byte[] getUserPhraseFromS3(String keyName) throws Exception {
        GetObjectArgs getObjectArgs = GetObjectArgs.builder().object(keyName).bucket(BUCKET_NAME).build();
        GetObjectResponse getObjectResponse = minioClient.getObject(getObjectArgs);
        byte[] bytes = getObjectResponse.readAllBytes();
        return bytes;
    }

}
