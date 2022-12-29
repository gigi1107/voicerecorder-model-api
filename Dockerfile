FROM openjdk:19

EXPOSE 8080

RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -y \
    apt-utils \
    curl \
    sudo \
    vim \
    postgresql \
    postgresql-contrib



ARG JAR_FILE=*.jar

ENV JAR_FILE=${JAR_FILE}


COPY target/${JAR_FILE} app.jar

COPY src/main/resources/schema.sql /docker-entrypoint-initdb.d/schema.sql
ENTRYPOINT ["java","-jar","/app.jar"]