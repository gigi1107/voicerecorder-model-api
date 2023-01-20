package com.voicerecorder.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.voicerecorder.entity.*;
import com.voicerecorder.repository.*;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

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

    private void deleteRequestNoBody(String suffix) throws IOException {
        HttpDelete request = new HttpDelete("http://localhost:8080/v1/" + suffix);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        Assertions.assertEquals(200, response.getCode());
    }

    private void postRequestNoBody(String suffix) throws IOException {
        HttpPost request = new HttpPost("http://localhost:8080/v1/" + suffix);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        Assertions.assertEquals(200, response.getCode());

    }

    private Long addPhrase(Long phraseSetId) throws IOException, ParseException {
        Phrase phrase = new Phrase(phraseSetId, "orig", "translation", "exRecPath");
        HttpPost request = new HttpPost("http://localhost:8080/v1/phrase");
        String json = GSON.toJson(phrase);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        Assertions.assertEquals(200, response.getCode());
        Phrase returnedPhrase =  GSON.fromJson(result, Phrase.class);
        return returnedPhrase.getId();
    }

    private void updatePhrase(Phrase updatedPhrase) throws IOException, ParseException {
        HttpPut request = new HttpPut("http://localhost:8080/v1/phrase");
        String json = GSON.toJson(updatedPhrase);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        Assertions.assertEquals(200, response.getCode());

    }

    private Long addPhraseSet() throws IOException, ParseException {
        PhraseSet phraseSet = new PhraseSet("myTestPhraseSet", DATE, DATE );
        HttpPost request = new HttpPost("http://localhost:8080/v1/phraseSet");
        String json = GSON.toJson(phraseSet);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        Assertions.assertEquals(200, response.getCode());
        PhraseSet returnedPhraseSet =  GSON.fromJson(result, PhraseSet.class);
        return returnedPhraseSet.getId();
    }

    private void updatePhraseSet(PhraseSet updatedPhraseSet) throws IOException {

        HttpPut request = new HttpPut("http://localhost:8080/v1/phraseSet");
        String json = GSON.toJson(updatedPhraseSet);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        Assertions.assertEquals(200, response.getCode());

    }

    private Long addUser() throws IOException, ParseException {
        HttpPost request = new HttpPost("http://localhost:8080/v1/user");
        User user = new User("fn", "ln", "la", "de");
        String json = GSON.toJson(user);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        Assertions.assertEquals(200, response.getCode());
        User returnedUser =  GSON.fromJson(result, User.class);
        return returnedUser.getId();
    }

    private void updateUser(User updateUser) throws IOException {

        HttpPut request = new HttpPut("http://localhost:8080/v1/user");
        String json = GSON.toJson(updateUser);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        Assertions.assertEquals(200, response.getCode());

    }

    private Long addUserPhrase(Long phraseId, Long userId) throws IOException, ParseException {
        HttpPost request = new HttpPost("http://localhost:8080/v1/userPhrase");
        UserPhrase userPhrase = new UserPhrase(phraseId, userId, DATE, "fp");
        String json = GSON.toJson(userPhrase);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        Assertions.assertEquals(200, response.getCode());
        UserPhrase returnedUser =  GSON.fromJson(result, UserPhrase.class);
        return returnedUser.getId();
    }

    private void updateUserPhrase(UserPhrase updateUserPhrase) throws IOException {

        HttpPut request = new HttpPut("http://localhost:8080/v1/userPhrase");
        String json = GSON.toJson(updateUserPhrase);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        Assertions.assertEquals(200, response.getCode());

    }

    private Long addUserPhraseComment(Long phraseId, Long userId) throws IOException, ParseException {
        HttpPost request = new HttpPost("http://localhost:8080/v1/userPhraseComment");
        UserPhraseComment userPhraseComment = new UserPhraseComment(phraseId, "comment", DATE, userId);
        String json = GSON.toJson(userPhraseComment);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        Assertions.assertEquals(200, response.getCode());
        UserPhraseComment returnedUser =  GSON.fromJson(result, UserPhraseComment.class);
        return returnedUser.getId();
    }

    private void updateUserPhraseComment(UserPhraseComment updatedUserPhraseComment) throws IOException {

        HttpPut request = new HttpPut("http://localhost:8080/v1/userPhraseComment");
        String json = GSON.toJson(updatedUserPhraseComment);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.execute(request);
        Assertions.assertEquals(200, response.getCode());

    }

    @Test
    void test_add_Phrase_200() throws Exception {
        Long phraseSetId = addPhraseSet();
        addPhrase(phraseSetId);
    }

    @Test
    void test_add_User_200() throws IOException, ParseException {
        addUser();
    }

    @Test
    void test_add_UserPhrase_200() throws IOException, ParseException {
        Long userId = addUser();
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        addUserPhrase(phraseId, userId);
    }

    @Test
    void test_add_UserPhraseComment_200() throws IOException, ParseException {
        Long userId = addUser();
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        Long userPhraseId = addUserPhrase(phraseId, userId);
        addUserPhraseComment(phraseId, userId);
    }

    // READ operations


    @Test
    void test_get_phrase_200() throws IOException, ParseException {
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        postRequestNoBody("phrase/"+phraseId);
    }

    @Test
    void test_get_phraseSet_200() throws IOException, ParseException {
        Long phraseSetId = addPhraseSet();
        postRequestNoBody("phraseSet/"+phraseSetId);
    }

    @Test
    void test_get_user_200() throws IOException, ParseException {
        Long userId = addUser();
        postRequestNoBody("user/"+userId);

    }
    @Test
    void test_get_userPhrase_200() throws IOException, ParseException {
        Long userId = addUser();
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        Long userPhraseId = addUserPhrase(phraseId, userId);
        postRequestNoBody("userPhrase/"+userPhraseId);
    }

    @Test
    void test_get_userPhraseComment_200() throws IOException, ParseException {
        Long userId = addUser();
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        Long userPhraseId = addUserPhrase(phraseId, userId);
        Long userPhraseCommentId = addUserPhraseComment(phraseId, userId);
        postRequestNoBody("userPhraseComment/"+userPhraseCommentId);
    }


    // UPDATE operations


    @Test
    void test_update_phrase_200() throws IOException, ParseException {
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        Phrase newPhrase = new Phrase(phraseId, phraseSetId, "change", "otherchange", "blarh");
        updatePhrase(newPhrase);

        postRequestNoBody("phrase/"+phraseId);

    }
    @Test
    void test_update_phraseSet_200() throws IOException, ParseException {
        Long phraseSetId = addPhraseSet();
        PhraseSet newPhraseSet = new PhraseSet(phraseSetId, "new", DATE, DATE );
        updatePhraseSet(newPhraseSet);

        postRequestNoBody("phraseSet/"+ phraseSetId);
    }

    @Test
    void test_update_user_200() throws IOException, ParseException {
        Long userId = addUser();
        User newUser = new User(userId, "new", "newln", "ble", "bla");
        updateUser( newUser);

        postRequestNoBody("user/"+userId);

    }
//
    @Test
    void test_update_userPhrase_200() throws IOException, ParseException {
        Long userId = addUser();
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        Long userPhraseId = addUserPhrase(phraseId, userId);
        UserPhrase newUserPhrase = new UserPhrase(userPhraseId, phraseId, userId, DATE, "newFP");

        updateUserPhrase(newUserPhrase);

        postRequestNoBody("userPhrase/"+userPhraseId);

    }

    @Test
    void test_update_userPhraseComment_200() throws IOException, ParseException {
        Long userId = addUser();
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        Long userPhraseId = addUserPhrase(phraseId, userId);
        Long userPhraseCommentId = addUserPhraseComment(phraseId, userId);
        UserPhraseComment userPhraseComment = new UserPhraseComment(userPhraseCommentId, phraseId, "comment new", DATE, userId);

        updateUserPhraseComment(userPhraseComment);

        postRequestNoBody("userPhraseComment/"+userPhraseCommentId);

    }

//    DELETE by Id operations


    @Test
    void test_delete_phrasebyId() throws IOException, ParseException {
        Long userId = addUser();
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        deleteRequestNoBody("phrase/"+phraseId);
    }

    @Test
    void test_deletePhraseSet_ById() throws IOException, ParseException {
        Long phraseSetId = addPhraseSet();
        deleteRequestNoBody("phraseSet/"+phraseSetId);
    }

    @Test
    void test_deleteUser_ById() throws IOException, ParseException {
        Long userId = addUser();
        deleteRequestNoBody("user/"+userId);
    }

    @Test
    void test_deleteUserPhrase_ById() throws IOException, ParseException {
        Long userId = addUser();
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        Long userPhraseId = addUserPhrase(phraseId, userId);
        deleteRequestNoBody("userPhrase/" +userPhraseId);
    }

    @Test
    void test_deleteUserPhraseComment() throws IOException, ParseException {
        Long userId = addUser();
        Long phraseSetId = addPhraseSet();
        Long phraseId = addPhrase(phraseSetId);
        Long userPhraseId = addUserPhrase(phraseId, userId);
        Long userPhraseCommentId = addUserPhraseComment(phraseId, userId);
        deleteRequestNoBody("userPhraseComment/"+userPhraseCommentId);
    }
}
