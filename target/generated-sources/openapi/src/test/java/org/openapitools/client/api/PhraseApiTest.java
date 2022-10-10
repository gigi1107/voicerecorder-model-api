/*
 * Phrase Recorder API
 * This is the API for the Phrase Recorder App.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: gdavidson1107@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Phrase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PhraseApi
 */
@Disabled
public class PhraseApiTest {

    private final PhraseApi api = new PhraseApi();

    /**
     * Add a new phrase to the Database
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void addPhraseTest() throws ApiException {
        Phrase phrase = null;
        api.addPhrase(phrase);
        // TODO: test validations
    }

    /**
     * Delete an existing phrase
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deletePhraseTest() throws ApiException {
        Long phraseId = null;
        api.deletePhrase(phraseId);
        // TODO: test validations
    }

    /**
     * Retrieves a given number of phrases from the Database
     *
     * Number should be greater than 0.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getPhraseTest() throws ApiException {
        Long numberPhrases = null;
        List<Phrase> response = api.getPhrase(numberPhrases);
        // TODO: test validations
    }

    /**
     * Update an existing phrase
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updatePhraseTest() throws ApiException {
        Phrase phrase = null;
        api.updatePhrase(phrase);
        // TODO: test validations
    }

}
