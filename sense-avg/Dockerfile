FROM openjdk:8-jre-alpine
MAINTAINER boyang
COPY target/sense-avg-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 80
ENTRYPOINT java -jar /app.jar --spring.profiles.active=prod
