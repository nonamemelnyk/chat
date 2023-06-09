#
# Build stage
#
#FROM maven:3.6.0-jdk-11-slim AS build
#COPY ./ /home/app
#RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:20

COPY ./target/chat-0.0.1-SNAPSHOT.jar chat.jar
CMD ["java", "-jar", "chat.jar"]
#CMD ["java", "-Xmx200m", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "/app/account-service.jar"]

EXPOSE 8080
#EXPOSE 6000 5005
