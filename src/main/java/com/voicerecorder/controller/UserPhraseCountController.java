package com.voicerecorder.controller;

import com.voicerecorder.entity.UserPhraseCount;
import com.voicerecorder.model.PhraseRequest;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserPhraseCountController {
    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;
    @PostMapping("/v1/phraseIds")
    ResponseEntity<List<Long>> getAllRemainingPhraseIdsForAUserAndPhraseSet(@RequestBody PhraseRequest phraseRequest) {
        List<Long> listOfPhraseIds;
        List<UserPhraseCount> userPhraseCountList;

        try {
            userPhraseCountList = voiceRecorderService.getRemainingPhrasesToRecordFromPhraseSet(phraseRequest.getUserId(), phraseRequest.getPhraseSetId());
            listOfPhraseIds = userPhraseCountList.stream().map(UserPhraseCount::getPhraseId).collect(Collectors.toList());


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(listOfPhraseIds);

    }
}
