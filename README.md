This repo contains the swagger.yml and generated Model.


To install this, run

mvn clean install assembly:single



To run via docker compose:
JAR_FILE=voice-recorder-model-api-1.0-SNAPSHOT-jar-with-dependencies.jar TAG=latest docker-compose up


----

If something is running on port 5432, run
sudo pkill -u postgres

-----


to look inside the DB as it runs:

psql -h 127.0.0.1 -p 5432 -U postgres



You can run via maven
export SPRING_PROFILES_ACTIVE=local
mvn spring-boot:run

### Make a request

curl http://localhost:8080/ping