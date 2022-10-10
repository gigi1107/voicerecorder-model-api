# PhraseApi

All URIs are relative to *https://indigenous.io/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addPhrase**](PhraseApi.md#addPhrase) | **POST** /phrase | Add a new phrase to the Database |
| [**deletePhrase**](PhraseApi.md#deletePhrase) | **DELETE** /phrase/{phraseId} | Delete an existing phrase |
| [**getPhrase**](PhraseApi.md#getPhrase) | **POST** /phrase/{numberPhrases} | Retrieves a given number of phrases from the Database |
| [**updatePhrase**](PhraseApi.md#updatePhrase) | **PUT** /phrase | Update an existing phrase |


<a name="addPhrase"></a>
# **addPhrase**
> addPhrase(phrase)

Add a new phrase to the Database

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    PhraseApi apiInstance = new PhraseApi(defaultClient);
    Phrase phrase = new Phrase(); // Phrase | Phrase object that needs to be added to the Database
    try {
      apiInstance.addPhrase(phrase);
    } catch (ApiException e) {
      System.err.println("Exception when calling PhraseApi#addPhrase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **phrase** | [**Phrase**](Phrase.md)| Phrase object that needs to be added to the Database | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **405** | Invalid input |  -  |

<a name="deletePhrase"></a>
# **deletePhrase**
> deletePhrase(phraseId)

Delete an existing phrase

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    PhraseApi apiInstance = new PhraseApi(defaultClient);
    Long phraseId = 56L; // Long | The phraseId of the phrase you want to delete from the Database
    try {
      apiInstance.deletePhrase(phraseId);
    } catch (ApiException e) {
      System.err.println("Exception when calling PhraseApi#deletePhrase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **phraseId** | **Long**| The phraseId of the phrase you want to delete from the Database | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | Invalid ID supplied |  -  |
| **404** | Phrase not found |  -  |
| **405** | Validation exception |  -  |

<a name="getPhrase"></a>
# **getPhrase**
> List&lt;Phrase&gt; getPhrase(numberPhrases)

Retrieves a given number of phrases from the Database

Number should be greater than 0.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    PhraseApi apiInstance = new PhraseApi(defaultClient);
    Long numberPhrases = 56L; // Long | The number(amount) of phrases to retrieve from the Database
    try {
      List<Phrase> result = apiInstance.getPhrase(numberPhrases);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PhraseApi#getPhrase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **numberPhrases** | **Long**| The number(amount) of phrases to retrieve from the Database | |

### Return type

[**List&lt;Phrase&gt;**](Phrase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Invalid numberPhrases value |  -  |

<a name="updatePhrase"></a>
# **updatePhrase**
> updatePhrase(phrase)

Update an existing phrase

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    PhraseApi apiInstance = new PhraseApi(defaultClient);
    Phrase phrase = new Phrase(); // Phrase | Phrase object that needs to be added to the Database
    try {
      apiInstance.updatePhrase(phrase);
    } catch (ApiException e) {
      System.err.println("Exception when calling PhraseApi#updatePhrase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **phrase** | [**Phrase**](Phrase.md)| Phrase object that needs to be added to the Database | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | Invalid ID supplied |  -  |
| **404** | Phrase not found |  -  |
| **405** | Validation exception |  -  |

