package com.voicerecorder.controller;


import com.voicerecorder.EntityModels.PhraseEntity;
import com.voicerecorder.Responses.PhrasesResponse;
import com.voicerecorder.service.VoiceRecorderService;
import org.openapitools.client.model.Phrase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @PutMapping("/v1/phrase")
    public ResponseEntity<Void> updatePhrase(@RequestBody Phrase phrase) {
        try {
            voiceRecorderService.updatePhrase((PhraseEntity)phrase);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }


    @PostMapping("/v1/phrase")
    @ResponseBody
    public ResponseEntity<Void> addPhrase(@RequestBody Phrase phrase) {
        try {
            voiceRecorderService.addPhrase((PhraseEntity)phrase);

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


    @PostMapping("/v1/phrase/phrases")
    public ResponseEntity<List<Phrase>> getPhrases(@RequestBody int numberToRetrieve) {

        PhrasesResponse response = voiceRecorderService.getPhrases(numberToRetrieve);

        return ResponseEntity.status(response.getStatus()).body(response.getPhrases());

    }


}
