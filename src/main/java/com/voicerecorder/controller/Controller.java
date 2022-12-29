package com.voicerecorder.controller;


import com.voicerecorder.entity.PhraseEntity;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;

    @GetMapping("/ping")
    public ResponseEntity<PhraseEntity> ping() {

        PhraseEntity response = voiceRecorderService.healthCheck();

        if (response != null) {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.internalServerError().body(null);
    }

//    @PutMapping("/v1/phrase")
//    public ResponseEntity<Void> updatePhrase(@RequestBody PhraseEntity phrase) {
//        try {
//            voiceRecorderService.updatePhrase(phrase);
//
//        } catch (Exception e ) {
//            return ResponseEntity.internalServerError().build();
//        }
//        return ResponseEntity.ok().build();
//    }


    @PostMapping("/v1/phrase")
    @ResponseBody
    public ResponseEntity<Void> addPhrase(@RequestBody PhraseEntity phrase) {
        try {
            voiceRecorderService.addPhrase(phrase);

        } catch (Exception e ) {
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
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

//
//    @PostMapping("/v1/phrase/phrases")
//    public ResponseEntity<List<Phrase>> getPhrases(@RequestBody int numberToRetrieve) {
//
//        PhrasesResponse response = voiceRecorderService.getPhrases(numberToRetrieve);
//
//        return ResponseEntity.status(response.getStatus()).body(response.getPhrases());
//
//    }


}
