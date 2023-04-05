package com.voicerecorder.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.voicerecorder.entity.UserPhrase;
import com.voicerecorder.entity.UserPhraseWithAudioFile;
import com.voicerecorder.helpers.FileAdapter;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

@SpringBootTest
public class S3FunctionalTest {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    Calendar calendar = Calendar.getInstance();
    long time = calendar.getTimeInMillis();
    private final Date DATE = new Date(time);
    private final Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .registerTypeAdapter(File.class, new FileAdapter()).create();
    @Test
    void saveAudioFile_S3_200() throws IOException, ParseException {
        File someFile = new File("/app/s3_audio_test.m4a");
        UserPhrase userPhrase = new UserPhrase(1L, 1L, DATE, "");

        UserPhraseWithAudioFile userPhraseWithAudioFile = new UserPhraseWithAudioFile(userPhrase, someFile);

        HttpPost request = new HttpPost("http://voicerecorder:8080/v1/userPhrase/s3");
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        String json = GSON.toJson(userPhraseWithAudioFile, UserPhraseWithAudioFile.class);

        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        Assertions.assertEquals(200, response.getCode());
        UserPhrase returnedPhrase = GSON.fromJson(result, UserPhrase.class);

        String regex = "recorded/" + userPhrase.getPhraseId() + "_" + userPhrase.getUserId() + "_" +
                userPhrase.getDateTime() + ".m4a";

        Assertions.assertEquals(regex, returnedPhrase.getFilePath());

        //get file
        String url = "http://voicerecorder:8080/v1/file/s3";
        HttpPost request2 = new HttpPost(url);
        request2.setHeader("Accept", "application/json");
        request2.setHeader("Content-type", "application/json");

        StringEntity stringEntity1 = new StringEntity(returnedPhrase.getFilePath());

        request2.setEntity(stringEntity1);

        CloseableHttpResponse response2 = httpClient.execute(request2);
        String entity = EntityUtils.toString(response2.getEntity());

        Assertions.assertEquals(200, response2.getCode());

        Assertions.assertNotNull(entity);

    }

    @Test
    void fetchNonexistentPhrase_failure() throws IOException, ParseException {
        //get file
        String url = "http://voicerecorder:8080/v1/file/s3";
        HttpPost request2 = new HttpPost(url);
        request2.setHeader("Accept", "application/json");
        request2.setHeader("Content-type", "application/json");

        StringEntity stringEntity1 = new StringEntity("/iDoNot/exist");

        request2.setEntity(stringEntity1);

        CloseableHttpResponse response2 = httpClient.execute(request2);
        String entity = EntityUtils.toString(response2.getEntity());

        Assertions.assertEquals(404, response2.getCode());

        Assertions.assertNotNull(entity);

    }
}

