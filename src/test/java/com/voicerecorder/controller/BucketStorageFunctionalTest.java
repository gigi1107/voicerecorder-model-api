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

import java.io.*;
import java.sql.Date;
import java.util.Calendar;

@SpringBootTest
public class BucketStorageFunctionalTest {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    Calendar calendar = Calendar.getInstance();
    long time = calendar.getTimeInMillis();
    private final Date DATE = new Date(time);
    private final Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .registerTypeAdapter(File.class, new FileAdapter()).create();
    @Test
    void saveAudioFileToBucket_200() throws IOException, ParseException {
        File someFile = new File("/app/s3_audio_test.flac");
        UserPhrase userPhrase = new UserPhrase(1L, 1L, DATE, "");

        UserPhraseWithAudioFile userPhraseWithAudioFile = new UserPhraseWithAudioFile(userPhrase, someFile);

        HttpPost request = new HttpPost("http://voicerecorder:8080/v1/file");
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
        String url = "http://voicerecorder:8080/v1/file/get";
        HttpPost request2 = new HttpPost(url);
        request2.setHeader("Accept", "application/json");
        request2.setHeader("Content-type", "application/json");

        StringEntity stringEntity1 = new StringEntity(returnedPhrase.getFilePath());

        request2.setEntity(stringEntity1);

        CloseableHttpResponse response2 = httpClient.execute(request2);
        String entity = EntityUtils.toString(response2.getEntity());
        System.out.println("entity response: " + entity);
        FileWriter myWriter = new FileWriter("outfile.txt");
        myWriter.write(entity);
        myWriter.close();

        Assertions.assertEquals(200, response2.getCode());

        Assertions.assertNotNull(entity);

        // test to make sure file is proper file



    }

    @Test
    void fetchNonexistentPhrase_failure() throws IOException, ParseException {
        //get file
        String url = "http://voicerecorder:8080/v1/file/iDoNot-exist";
        HttpPost request2 = new HttpPost(url);
        request2.setHeader("Accept", "application/json");
        request2.setHeader("Content-type", "application/json");

        CloseableHttpResponse response2 = httpClient.execute(request2);
        String entity = EntityUtils.toString(response2.getEntity());

        Assertions.assertEquals(404, response2.getCode());

        Assertions.assertNotNull(entity);

    }

//    @Test
//    void verify_contents_byteArray() {
//        try {
//            // Step 1: Read the contents of the text file containing the byte array
//            FileInputStream fis = new FileInputStream("outfile.txt");
//            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//
//            String byteString = br.readLine();
//
//            // Step 2: Convert the contents of the text file into a byte array
//            String[] byteValues = byteString.substring(1, byteString.length() - 1).split(",");
//            byte[] byteArray = new byte[byteValues.length];
//
//            for (int i = 0; i < byteValues.length; i++) {
//                byteArray[i] = Byte.parseByte(byteValues[i].trim());
//            }
//
//            // Step 3: Write the byte array to a new file with a ".flac" file extension
//            FileOutputStream fos = new FileOutputStream("output.flac");
//            fos.write(byteArray);
//            fos.close();
//
//            System.out.println("Byte array successfully written to file.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    }




