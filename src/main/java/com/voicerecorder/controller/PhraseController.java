package com.voicerecorder.controller;


import com.voicerecorder.entity.Phrase;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PhraseController {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;

    @PostMapping("/v1/phrase")
    @ResponseBody
    public ResponseEntity<Phrase> addPhrase(@RequestBody Phrase phrase) {
        Phrase response;
        try {
            response = voiceRecorderService.addPhrase(phrase);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(response);

    }

    @PostMapping("/v1/phrase/{phraseId}")
    public ResponseEntity<Phrase> getPhraseById(@PathVariable Long phraseId) {
        Phrase phrase;
        try {
            phrase = voiceRecorderService.getPhraseById(phraseId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(phrase);

    }

    @PostMapping("/v1/phrase/all")
    public ResponseEntity<List<Phrase>> getAllPhrasesByIds(@RequestBody List<Long> phraseIds) {
        List<Phrase> phrases;
        try {
            phrases = voiceRecorderService.getPhraseListByIds(phraseIds);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().body(phrases);

    }



    @PutMapping("/v1/phrase")
    public ResponseEntity<Void> updatePhrase(@RequestBody Phrase phrase) {
        try {
           voiceRecorderService.updatePhrase(phrase);

        } catch (Exception e ) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/phrase/{phraseId}")
    public ResponseEntity<Void> deletePhrase(@PathVariable String phraseId) {
        try {
            Long id = Long.parseLong(phraseId);
            voiceRecorderService.deletePhrase(id);

        } catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

}
