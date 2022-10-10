# openapi-java-client

Phrase Recorder API
- API version: 1.0.0
  - Build date: 2022-10-09T22:17:02.516303-07:00[America/Los_Angeles]

This is the API for the Phrase Recorder App.


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'openapi-java-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'openapi-java-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "org.openapitools:openapi-java-client:1.0.0"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

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

## Documentation for API Endpoints

All URIs are relative to *https://indigenous.io/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*PhraseApi* | [**addPhrase**](docs/PhraseApi.md#addPhrase) | **POST** /phrase | Add a new phrase to the Database
*PhraseApi* | [**deletePhrase**](docs/PhraseApi.md#deletePhrase) | **DELETE** /phrase/{phraseId} | Delete an existing phrase
*PhraseApi* | [**getPhrase**](docs/PhraseApi.md#getPhrase) | **POST** /phrase/{numberPhrases} | Retrieves a given number of phrases from the Database
*PhraseApi* | [**updatePhrase**](docs/PhraseApi.md#updatePhrase) | **PUT** /phrase | Update an existing phrase
*UserApi* | [**createUser**](docs/UserApi.md#createUser) | **POST** /user | Creates user with given info
*UserApi* | [**deleteUser**](docs/UserApi.md#deleteUser) | **DELETE** /user/{userId} | Delete an existing user
*UserApi* | [**editUser**](docs/UserApi.md#editUser) | **PUT** /user | Edits user with given info
*UserApi* | [**getUser**](docs/UserApi.md#getUser) | **POST** /user/retrieve | Get user
*UserPhraseApi* | [**deleteUserPhraseDb**](docs/UserPhraseApi.md#deleteUserPhraseDb) | **DELETE** /userPhrase/database/{userPhraseId} | Delete a userPhrase from Database
*UserPhraseApi* | [**deleteUserPhraseS3**](docs/UserPhraseApi.md#deleteUserPhraseS3) | **DELETE** /userPhrase/s3/{userPhraseId} | Delete a userPhrase from S3
*UserPhraseApi* | [**editUserPhraseDatabase**](docs/UserPhraseApi.md#editUserPhraseDatabase) | **PUT** /userPhrase/database | Edit a userPhrase to Database
*UserPhraseApi* | [**editUserPhraseS3**](docs/UserPhraseApi.md#editUserPhraseS3) | **PUT** /userPhrase/s3 | Edits a userPhrase in S3
*UserPhraseApi* | [**getUserPhraseDb**](docs/UserPhraseApi.md#getUserPhraseDb) | **POST** /userPhrase/database/{userPhraseId} | Gets a userPhrase by ID from Database
*UserPhraseApi* | [**getUserPhraseS3**](docs/UserPhraseApi.md#getUserPhraseS3) | **POST** /userPhrase/s3/{userPhraseId} | Get a userPhrase by ID from S3
*UserPhraseApi* | [**saveUserPhraseDatabase**](docs/UserPhraseApi.md#saveUserPhraseDatabase) | **POST** /userPhrase/database | Saves a userPhrase to Database
*UserPhraseApi* | [**saveUserPhraseS3**](docs/UserPhraseApi.md#saveUserPhraseS3) | **POST** /userPhrase/s3 | Saves a userPhrase to S3


## Documentation for Models

 - [Phrase](docs/Phrase.md)
 - [Recording](docs/Recording.md)
 - [User](docs/User.md)
 - [UserPhrase](docs/UserPhrase.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

gdavidson1107@gmail.com
