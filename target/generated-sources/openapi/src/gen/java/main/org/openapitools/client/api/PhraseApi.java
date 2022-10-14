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

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.openapitools.client.model.Phrase;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class PhraseApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PhraseApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PhraseApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for addPhrase
     * @param phrase Phrase object that needs to be added to the Database (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 405 </td><td> Invalid input </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call addPhraseCall(Phrase phrase, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = phrase;

        // create path and map variables
        String localVarPath = "/phrase";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call addPhraseValidateBeforeCall(Phrase phrase, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'phrase' is set
        if (phrase == null) {
            throw new ApiException("Missing the required parameter 'phrase' when calling addPhrase(Async)");
        }
        

        okhttp3.Call localVarCall = addPhraseCall(phrase, _callback);
        return localVarCall;

    }

    /**
     * Add a new phrase to the Database
     * 
     * @param phrase Phrase object that needs to be added to the Database (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 405 </td><td> Invalid input </td><td>  -  </td></tr>
     </table>
     */
    public void addPhrase(Phrase phrase) throws ApiException {
        addPhraseWithHttpInfo(phrase);
    }

    /**
     * Add a new phrase to the Database
     * 
     * @param phrase Phrase object that needs to be added to the Database (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 405 </td><td> Invalid input </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> addPhraseWithHttpInfo(Phrase phrase) throws ApiException {
        okhttp3.Call localVarCall = addPhraseValidateBeforeCall(phrase, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Add a new phrase to the Database (asynchronously)
     * 
     * @param phrase Phrase object that needs to be added to the Database (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 405 </td><td> Invalid input </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call addPhraseAsync(Phrase phrase, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = addPhraseValidateBeforeCall(phrase, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for deletePhrase
     * @param phraseId The phraseId of the phrase you want to delete from the Database (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 400 </td><td> Invalid ID supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Phrase not found </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Validation exception </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deletePhraseCall(Long phraseId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/phrase/{phraseId}"
            .replaceAll("\\{" + "phraseId" + "\\}", localVarApiClient.escapeString(phraseId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deletePhraseValidateBeforeCall(Long phraseId, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'phraseId' is set
        if (phraseId == null) {
            throw new ApiException("Missing the required parameter 'phraseId' when calling deletePhrase(Async)");
        }
        

        okhttp3.Call localVarCall = deletePhraseCall(phraseId, _callback);
        return localVarCall;

    }

    /**
     * Delete an existing phrase
     * 
     * @param phraseId The phraseId of the phrase you want to delete from the Database (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 400 </td><td> Invalid ID supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Phrase not found </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Validation exception </td><td>  -  </td></tr>
     </table>
     */
    public void deletePhrase(Long phraseId) throws ApiException {
        deletePhraseWithHttpInfo(phraseId);
    }

    /**
     * Delete an existing phrase
     * 
     * @param phraseId The phraseId of the phrase you want to delete from the Database (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 400 </td><td> Invalid ID supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Phrase not found </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Validation exception </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> deletePhraseWithHttpInfo(Long phraseId) throws ApiException {
        okhttp3.Call localVarCall = deletePhraseValidateBeforeCall(phraseId, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Delete an existing phrase (asynchronously)
     * 
     * @param phraseId The phraseId of the phrase you want to delete from the Database (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 400 </td><td> Invalid ID supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Phrase not found </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Validation exception </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deletePhraseAsync(Long phraseId, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = deletePhraseValidateBeforeCall(phraseId, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
    /**
     * Build call for getPhrases
     * @param numberPhrases The number(amount) of phrases to retrieve from the Database (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> successful operation </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid numberPhrases value </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getPhraseCall(Long numberPhrases, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/phrase/{numberPhrases}"
            .replaceAll("\\{" + "numberPhrases" + "\\}", localVarApiClient.escapeString(numberPhrases.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getPhraseValidateBeforeCall(Long numberPhrases, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'numberPhrases' is set
        if (numberPhrases == null) {
            throw new ApiException("Missing the required parameter 'numberPhrases' when calling getPhrases(Async)");
        }
        

        okhttp3.Call localVarCall = getPhraseCall(numberPhrases, _callback);
        return localVarCall;

    }

    /**
     * Retrieves a given number of phrases from the Database
     * Number should be greater than 0.
     * @param numberPhrases The number(amount) of phrases to retrieve from the Database (required)
     * @return List&lt;Phrase&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> successful operation </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid numberPhrases value </td><td>  -  </td></tr>
     </table>
     */
    public List<Phrase> getPhrase(Long numberPhrases) throws ApiException {
        ApiResponse<List<Phrase>> localVarResp = getPhraseWithHttpInfo(numberPhrases);
        return localVarResp.getData();
    }

    /**
     * Retrieves a given number of phrases from the Database
     * Number should be greater than 0.
     * @param numberPhrases The number(amount) of phrases to retrieve from the Database (required)
     * @return ApiResponse&lt;List&lt;Phrase&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> successful operation </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid numberPhrases value </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<Phrase>> getPhraseWithHttpInfo(Long numberPhrases) throws ApiException {
        okhttp3.Call localVarCall = getPhraseValidateBeforeCall(numberPhrases, null);
        Type localVarReturnType = new TypeToken<List<Phrase>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieves a given number of phrases from the Database (asynchronously)
     * Number should be greater than 0.
     * @param numberPhrases The number(amount) of phrases to retrieve from the Database (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> successful operation </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid numberPhrases value </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getPhraseAsync(Long numberPhrases, final ApiCallback<List<Phrase>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getPhraseValidateBeforeCall(numberPhrases, _callback);
        Type localVarReturnType = new TypeToken<List<Phrase>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updatePhrase
     * @param phrase Phrase object that needs to be added to the Database (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 400 </td><td> Invalid ID supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Phrase not found </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Validation exception </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updatePhraseCall(Phrase phrase, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = phrase;

        // create path and map variables
        String localVarPath = "/phrase";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updatePhraseValidateBeforeCall(Phrase phrase, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'phrase' is set
        if (phrase == null) {
            throw new ApiException("Missing the required parameter 'phrase' when calling updatePhrase(Async)");
        }
        

        okhttp3.Call localVarCall = updatePhraseCall(phrase, _callback);
        return localVarCall;

    }

    /**
     * Update an existing phrase
     * 
     * @param phrase Phrase object that needs to be added to the Database (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 400 </td><td> Invalid ID supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Phrase not found </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Validation exception </td><td>  -  </td></tr>
     </table>
     */
    public void updatePhrase(Phrase phrase) throws ApiException {
        updatePhraseWithHttpInfo(phrase);
    }

    /**
     * Update an existing phrase
     * 
     * @param phrase Phrase object that needs to be added to the Database (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 400 </td><td> Invalid ID supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Phrase not found </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Validation exception </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> updatePhraseWithHttpInfo(Phrase phrase) throws ApiException {
        okhttp3.Call localVarCall = updatePhraseValidateBeforeCall(phrase, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Update an existing phrase (asynchronously)
     * 
     * @param phrase Phrase object that needs to be added to the Database (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 400 </td><td> Invalid ID supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Phrase not found </td><td>  -  </td></tr>
        <tr><td> 405 </td><td> Validation exception </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updatePhraseAsync(Phrase phrase, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = updatePhraseValidateBeforeCall(phrase, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
}
