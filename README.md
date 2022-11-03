This repo contains the swagger.yml and generated Model.


To install this, run mvn clean install assembly:single



To run via docker compose:
JAR_FILE=voice-recorder-model-api-1.0-SNAPSHOT-jar-with-dependencies.jar TAG=latest docker-compose up --build



to look inside the DB as it runs:

psql -h 127.0.0.1 -p 5432 -U postgres

