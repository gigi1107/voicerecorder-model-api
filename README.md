This repo contains the swagger.yml and generated Model.


To install this, run

mvn clean install -Dmaven.test.skip



To run via docker compose:

Make sure to build the docker image first

JAR_FILE=voice-recorder-model-api-1.1-SNAPSHOT.jar TAG=latest docker-compose build

then run 

JAR_FILE=voice-recorder-model-api-1.1-SNAPSHOT.jar TAG=latest docker-compose up db


----

If something is running on port 5432, run
sudo pkill -u postgres

-----


to look inside the DB as it runs:

psql -h 127.0.0.1 -p 5432 -U postgres

Docker compose up will just bring up the database but IF the app fails, it wont giver err messages,
 but then just run the app with MAVEN and this will give you a stack trace:

You can run via maven
export SPRING_PROFILES_ACTIVE=local
mvn spring-boot:run

### Make a request

curl -i -v http://localhost:8080/ping




TODO

 <plugin>
                <groupId>org.openapitools</groupId>
                <artifactId>openapi-generator-maven-plugin</artifactId>
                <!-- RELEASE_VERSION -->
                <version>6.2.1</version>
                <!-- /RELEASE_VERSION -->
                <executions>
                    <execution>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <inputSpec>swagger.yml</inputSpec>
                            <generatorName>java</generatorName>
                            <configOptions>
                                <sourceFolder>src/gen/java/main</sourceFolder>
                            </configOptions>
                        </configuration>
                    </execution>
                </executions>
            </plugin>


            In a different project so we can have the API