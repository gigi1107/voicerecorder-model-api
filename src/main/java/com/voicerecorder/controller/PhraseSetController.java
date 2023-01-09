package com.voicerecorder.controller;

import com.voicerecorder.entity.PhraseSet;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

public class PhraseSetController {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;


    @PostMapping("/v1/phraseSet")
    @ResponseBody
    public ResponseEntity<Void> addphraseSetSet(@RequestBody PhraseSet phraseSet) {
        try {
            voiceRecorderService.addPhraseSet(phraseSet);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

    @PostMapping("/v1/phraseSet/{phraseSetId}")
    public ResponseEntity<PhraseSet> getphraseSetById(@PathVariable Long phraseSetId) {
        PhraseSet phraseSet;

        try {
            phraseSet = voiceRecorderService.getPhraseSetById(phraseSetId);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(phraseSet);

    }

    @PutMapping("/v1/phraseSet")
    public ResponseEntity<Void> updatephraseSet(@RequestBody PhraseSet phraseSet) {
        try {
            voiceRecorderService.updatePhraseSet(phraseSet);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/phraseSet/{phraseSetId}")
    public ResponseEntity<Void> deletephraseSet(@PathVariable String phraseSetId) {
        try {
            Long id = Long.parseLong(phraseSetId);
            voiceRecorderService.deletePhraseSetById(id);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

}
