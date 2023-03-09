package com.voicerecorder.controller;

import com.voicerecorder.entity.Phrase;
import com.voicerecorder.entity.UserPhraseCount;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserPhraseCountController {
    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;
    @PostMapping("/v1/phraseSet/phraseSetId/{phraseSetId}")
    ResponseEntity<List<Long>> getAllRemainingPhraseIdsForAUserAndPhraseSet(@RequestBody Map<String, Long> userIdJson, @PathVariable Long phraseSetId) {
        Long userId = userIdJson.get("userId");

        List<Long> listOfPhraseIds;
        List<UserPhraseCount> userPhraseCountList;

        try {
            userPhraseCountList = voiceRecorderService.getRemainingPhrasesToRecordFromPhraseSet(userId, phraseSetId);
            listOfPhraseIds = userPhraseCountList.stream().map(UserPhraseCount::getPhraseId).collect(Collectors.toList());


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(listOfPhraseIds);

    }
}
