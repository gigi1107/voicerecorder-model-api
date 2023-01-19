package com.voicerecorder.controller;

import com.google.gson.GsonBuilder;
import com.voicerecorder.entity.*;
import com.voicerecorder.repository.*;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

@SpringBootTest
class ControllerFunctionalTest {

    private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").create();


    static Calendar calendar = Calendar.getInstance();
    static long time = calendar.getTimeInMillis();
    private static final Date DATE = new Date(time);

    @Autowired
    PhraseRepository phraseRepository;

    @Autowired
    PhraseSetRepository phraseSetRepository;

    @Autowired
    UserPhraseCommentsRepository userPhraseCommentsRepository;

    @Autowired
    UserPhraseRepository userPhraseRepository;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void cleanupState() {
        userPhraseCommentsRepository.deleteAll();
        userPhraseCommentsRepository.flush();

        userPhraseRepository.deleteAll();
        userPhraseRepository.flush();

        phraseRepository.deleteAll();
        phraseRepository.flush();

        phraseSetRepository.deleteAll();
        phraseSetRepository.flush();

        userRepository.deleteAll();
        userRepository.flush();
    }

    private VoiceRecorderObject postRequest(String suffix, Object bodyObject) throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost request = new HttpPost("http://localhost:8080/v1/" + suffix);
        String json = GSON.toJson(bodyObject);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        VoiceRecorderObject voiceRecorderObject = GSON.fromJson(result, VoiceRecorderObject.class);
        return voiceRecorderObject;

    }

    private HttpResponse postRequestNoBody(String suffix) throws IOException {
        HttpUriRequest request = new HttpPost("http://localhost:8080/v1/" + suffix);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        return HttpClientBuilder.create().build().execute(request);
    }

    private HttpResponse putRequest(String suffix, Object bodyObject) throws IOException {
        HttpUriRequest request = new HttpPut("http://localhost:8080/v1/" + suffix);
        String json = GSON.toJson(bodyObject);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        return HttpClientBuilder.create().build().execute(request);
    }

    private HttpResponse deleteRequestNoBody(String suffix) throws IOException {
        HttpUriRequest request = new HttpDelete("http://localhost:8080/v1/" + suffix);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        return HttpClientBuilder.create().build().execute(request);
    }

    private Long addPhrase(Long phraseSetId) throws IOException, ParseException {
        Phrase phrase = new Phrase(phraseSetId, "orig", "translation", "exRecPath");
        VoiceRecorderObject voiceRecorderObject = postRequest("phrase", phrase);
        return voiceRecorderObject.getId();

    }

    private Long addPhraseSet() throws IOException, ParseException {
        PhraseSet phraseSet = new PhraseSet("myTestPhraseSet", DATE, DATE );
        VoiceRecorderObject voiceRecorderObject = postRequest("phraseSet", phraseSet);
        return voiceRecorderObject.getId();
    }

    private void addUser() throws IOException {
//        User user = new User("fn", "ln", "la", "de");
//        HttpResponse httpResponse = postRequest("user", user);
//        Assertions.assertEquals(200, httpResponse.getCode());
    }

    private void addUserPhrase() throws IOException {
//        UserPhrase userPhrase = new UserPhrase(1L, 1L, DATE, "fp");
//        HttpResponse httpResponse = postRequest("userPhrase", userPhrase);
//        Assertions.assertEquals(200, httpResponse.getCode());
    }

    private void addUserPhraseComment() throws IOException {
//        UserPhraseComment userPhraseComment = new UserPhraseComment(1L, "comment", DATE, 1L);
//        HttpResponse httpResponse = postRequest("userPhraseComment", userPhraseComment);
//        Assertions.assertEquals(200, httpResponse.getCode());
    }

    @Test
    void test_add_phraseSet_200() throws IOException, ParseException {
        addPhraseSet();
    }

    @Test
    void test_add_Phrase_200() throws Exception {
        Long phraseSetId = addPhraseSet();
        addPhrase(phraseSetId);
    }

    @Test
    void test_add_User_200() throws IOException {
        addUser();
    }

//    @Test
//    void test_add_UserPhrase_200() throws IOException {
//        addUser();
//        addPhraseSet();
//        addPhrase();
//        addUserPhrase();
//    }
//
//    @Test
//    void test_add_UserPhraseComment_200() throws IOException {
//        addUser();
//        addPhraseSet();
//        addPhrase();
//        addUserPhrase();
//        addUserPhraseComment();
//    }
//
//    // READ operations
//
//
//    @Test
//    void test_get_phrase_200() throws IOException {
//        addPhraseSet();
//        addPhrase();
//        HttpResponse httpResponse = postRequestNoBody("phrase/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//    @Test
//    void test_get_phraseSet_200() throws IOException {
//        addPhraseSet();
//        HttpResponse httpResponse = postRequestNoBody("phraseSet/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//    @Test
//    void test_get_user_200() throws IOException {
//        addUser();
//        HttpResponse httpResponse = postRequestNoBody("user/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//
//    }
//    @Test
//    void test_get_userPhrase_200() throws IOException {
//        addUser();
//        addPhraseSet();
//        addPhrase();
//        addUserPhrase();
//
//        HttpResponse httpResponse = postRequestNoBody("userPhrase/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//    @Test
//    void test_get_userPhraseComment_200() throws IOException {
//        addUser();
//        addPhraseSet();
//        addPhrase();
//        addUserPhrase();
//        addUserPhraseComment();
//        HttpResponse httpResponse = postRequestNoBody("userPhraseComment/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//
//    // UPDATE operations
//
//
//    @Test
//    void test_update_phrase_200() throws IOException {
//        addPhraseSet();
//        addPhrase();
//        Phrase newPhrase = new Phrase(1L, "change", "otherchange", "blarh");
//        HttpResponse httpResponse = putRequest("phrase", newPhrase);
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//    @Test
//    void test_update_phraseSet_200() throws IOException {
//        addPhraseSet();
//        PhraseSet newPhraseSet = new PhraseSet("new", DATE, DATE );
//        HttpResponse httpResponse = putRequest("phraseSet", newPhraseSet);
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//    @Test
//    void test_update_user_200() throws IOException {
//        addUser();
//        User newUser = new User(1L, "new", "newln", "ble", "bla");
//        HttpResponse httpResponse = putRequest("user", newUser);
//        Assertions.assertEquals(200, httpResponse.getCode());
//
//    }
//
//    @Test
//    void test_update_userPhrase_200() throws IOException {
//        addUser();
//        addPhraseSet();
//        addPhrase();
//        addUserPhrase();
//        UserPhrase newUserPhrase = new UserPhrase(1L, 1L, DATE, "newFP");
//        HttpResponse httpResponse = putRequest("userPhrase", newUserPhrase);
//        Assertions.assertEquals(200, httpResponse.getCode());
//
//    }
//
//    @Test
//    void test_update_userPhraseComment_200() throws IOException {
//        addUser();
//        addPhraseSet();
//        addPhrase();
//        addUserPhraseComment();
//        UserPhraseComment userPhraseComment = new UserPhraseComment(1L, "comment new", DATE, 1L);
//        HttpResponse httpResponse = putRequest("userPhraseComment", userPhraseComment);
//        Assertions.assertEquals(200, httpResponse.getCode());
//
//    }
//
//    //DELETE by Id operations
//
//
//    @Test
//    void test_delete_phrasebyId() throws IOException {
//        addPhraseSet();
//        addPhrase();
//        HttpResponse httpResponse = deleteRequestNoBody("phrase/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//    @Test
//    void test_deletePhraseSet_ById() throws IOException {
//        addPhraseSet();
//        HttpResponse httpResponse = deleteRequestNoBody("phraseSet/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//    @Test
//    void test_deleteUser_ById() throws IOException {
//        addUser();
//        HttpResponse httpResponse = deleteRequestNoBody("user/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//    @Test
//    void test_deleteUserPhrase_ById() throws IOException {
//        addUser();
//        addPhraseSet();
//        addPhrase();
//        HttpResponse httpResponse = deleteRequestNoBody("userPhrase/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//
//    @Test
//    void test_deleteUserPhraseComment() throws IOException {
//        addUser();
//        addPhraseSet();
//        addPhrase();
//        addUserPhraseComment();
//        HttpResponse httpResponse = deleteRequestNoBody("userPhraseComment/1");
//        Assertions.assertEquals(200, httpResponse.getCode());
//    }
//}
}