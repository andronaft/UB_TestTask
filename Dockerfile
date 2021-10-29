FROM openjdk:8-jdk-alpine
MAINTAINER zuk
COPY ./target/zuk-1.0.1.jar zuk-1.0.1.jar
ENTRYPOINT ["java","-jar","/zuk-1.0.1.jar"]