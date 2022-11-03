FROM openjdk:11

EXPOSE 8080

ARG JAR_FILE=*.jar

ENV JAR_FILE=${JAR_FILE}


COPY target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]