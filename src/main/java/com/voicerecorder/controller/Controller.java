package com.voicerecorder.controller;


import org.openapitools.client.model.Phrase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    @PutMapping("/v1/phrase")
    public ResponseEntity<Void> updatePhrase(@RequestBody Phrase phrase) {
    }


    @PostMapping("/v1/phrase")
    @ResponseBody
    public ResponseEntity<Void> addPhrase(@RequestBody Phrase phrase) {
    }


    @DeleteMapping("/v1/phrase/{phraseId}")
    public ResponseEntity<Void> deletePhrase(@PathVariable String phraseId) {
        return "Post some Foos";
    }


    @PostMapping("/v1/phrase/phrases")
    public ResponseEntity<List<Phrase>> getPhrases(@RequestBody int numberToRetrieve) {
    }


}
