FROM openjdk:8-jdk-alpine

# For Java 11
#FROM adoptopenjdk/openjdk11:alpine-jre

# aven build -> finalName
ARG JAR_FILE=target/ecommerce.order.demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ecommerce.order.demo.jar
ENTRYPOINT ["java","-jar","ecommerce.order.demo.jar"]

