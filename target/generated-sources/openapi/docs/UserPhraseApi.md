# UserPhraseApi

All URIs are relative to *https://indigenous.io/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteUserPhraseDb**](UserPhraseApi.md#deleteUserPhraseDb) | **DELETE** /userPhrase/database/{userPhraseId} | Delete a userPhrase from Database |
| [**deleteUserPhraseS3**](UserPhraseApi.md#deleteUserPhraseS3) | **DELETE** /userPhrase/s3/{userPhraseId} | Delete a userPhrase from S3 |
| [**editUserPhraseDatabase**](UserPhraseApi.md#editUserPhraseDatabase) | **PUT** /userPhrase/database | Edit a userPhrase to Database |
| [**editUserPhraseS3**](UserPhraseApi.md#editUserPhraseS3) | **PUT** /userPhrase/s3 | Edits a userPhrase in S3 |
| [**getUserPhraseDb**](UserPhraseApi.md#getUserPhraseDb) | **POST** /userPhrase/database/{userPhraseId} | Gets a userPhrase by ID from Database |
| [**getUserPhraseS3**](UserPhraseApi.md#getUserPhraseS3) | **POST** /userPhrase/s3/{userPhraseId} | Get a userPhrase by ID from S3 |
| [**saveUserPhraseDatabase**](UserPhraseApi.md#saveUserPhraseDatabase) | **POST** /userPhrase/database | Saves a userPhrase to Database |
| [**saveUserPhraseS3**](UserPhraseApi.md#saveUserPhraseS3) | **POST** /userPhrase/s3 | Saves a userPhrase to S3 |


<a name="deleteUserPhraseDb"></a>
# **deleteUserPhraseDb**
> deleteUserPhraseDb(userPhraseId)

Delete a userPhrase from Database

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserPhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    UserPhraseApi apiInstance = new UserPhraseApi(defaultClient);
    Long userPhraseId = 56L; // Long | The userPhrase Id of the userPhrase you want to delete from the Database
    try {
      apiInstance.deleteUserPhraseDb(userPhraseId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPhraseApi#deleteUserPhraseDb");
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
| **userPhraseId** | **Long**| The userPhrase Id of the userPhrase you want to delete from the Database | |

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
| **0** | Successful Operation |  -  |

<a name="deleteUserPhraseS3"></a>
# **deleteUserPhraseS3**
> deleteUserPhraseS3(userPhraseId)

Delete a userPhrase from S3

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserPhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    UserPhraseApi apiInstance = new UserPhraseApi(defaultClient);
    Long userPhraseId = 56L; // Long | The userPhraseID of the userPhrase you want to delete from S3
    try {
      apiInstance.deleteUserPhraseS3(userPhraseId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPhraseApi#deleteUserPhraseS3");
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
| **userPhraseId** | **Long**| The userPhraseID of the userPhrase you want to delete from S3 | |

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
| **200** | Successful Operation |  -  |
| **404** | UserPhrase Id not found in S3. |  -  |

<a name="editUserPhraseDatabase"></a>
# **editUserPhraseDatabase**
> editUserPhraseDatabase(userPhrase)

Edit a userPhrase to Database

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserPhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    UserPhraseApi apiInstance = new UserPhraseApi(defaultClient);
    UserPhrase userPhrase = new UserPhrase(); // UserPhrase | UserPhrase object
    try {
      apiInstance.editUserPhraseDatabase(userPhrase);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPhraseApi#editUserPhraseDatabase");
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
| **userPhrase** | [**UserPhrase**](UserPhrase.md)| UserPhrase object | |

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
| **0** | Successful Operation |  -  |

<a name="editUserPhraseS3"></a>
# **editUserPhraseS3**
> Object editUserPhraseS3(userPhrase)

Edits a userPhrase in S3

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserPhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    UserPhraseApi apiInstance = new UserPhraseApi(defaultClient);
    UserPhrase userPhrase = new UserPhrase(); // UserPhrase | UserPhrase object
    try {
      Object result = apiInstance.editUserPhraseS3(userPhrase);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPhraseApi#editUserPhraseS3");
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
| **userPhrase** | [**UserPhrase**](UserPhrase.md)| UserPhrase object | |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Operation |  -  |

<a name="getUserPhraseDb"></a>
# **getUserPhraseDb**
> getUserPhraseDb(userPhraseId)

Gets a userPhrase by ID from Database

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserPhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    UserPhraseApi apiInstance = new UserPhraseApi(defaultClient);
    Long userPhraseId = 56L; // Long | The userPhrase Id of the userPhrase you want to get from the Database
    try {
      apiInstance.getUserPhraseDb(userPhraseId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPhraseApi#getUserPhraseDb");
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
| **userPhraseId** | **Long**| The userPhrase Id of the userPhrase you want to get from the Database | |

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
| **0** | Successful Operation |  -  |

<a name="getUserPhraseS3"></a>
# **getUserPhraseS3**
> getUserPhraseS3(userPhraseId)

Get a userPhrase by ID from S3

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserPhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    UserPhraseApi apiInstance = new UserPhraseApi(defaultClient);
    Long userPhraseId = 56L; // Long | The userPhraseID of the userPhrase you want to get from S3
    try {
      apiInstance.getUserPhraseS3(userPhraseId);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPhraseApi#getUserPhraseS3");
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
| **userPhraseId** | **Long**| The userPhraseID of the userPhrase you want to get from S3 | |

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
| **200** | Successful Operation |  -  |
| **404** | UserPhrase Id not found in S3. |  -  |

<a name="saveUserPhraseDatabase"></a>
# **saveUserPhraseDatabase**
> saveUserPhraseDatabase(userPhrase)

Saves a userPhrase to Database

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserPhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    UserPhraseApi apiInstance = new UserPhraseApi(defaultClient);
    UserPhrase userPhrase = new UserPhrase(); // UserPhrase | UserPhrase object
    try {
      apiInstance.saveUserPhraseDatabase(userPhrase);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPhraseApi#saveUserPhraseDatabase");
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
| **userPhrase** | [**UserPhrase**](UserPhrase.md)| UserPhrase object | |

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
| **0** | Successful Operation |  -  |

<a name="saveUserPhraseS3"></a>
# **saveUserPhraseS3**
> String saveUserPhraseS3(userPhrase)

Saves a userPhrase to S3

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserPhraseApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://indigenous.io/v1");

    UserPhraseApi apiInstance = new UserPhraseApi(defaultClient);
    UserPhrase userPhrase = new UserPhrase(); // UserPhrase | UserPhrase object
    try {
      String result = apiInstance.saveUserPhraseS3(userPhrase);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPhraseApi#saveUserPhraseS3");
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
| **userPhrase** | [**UserPhrase**](UserPhrase.md)| UserPhrase object | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful Operation |  -  |

