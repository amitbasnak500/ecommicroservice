FROM openjdk:8-jdk-alpine

# For Java 11
#FROM adoptopenjdk/openjdk11:alpine-jre

# aven build -> finalName
ARG JAR_FILE=target/ecommerce.order-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ecommerce.order.jar
ENTRYPOINT ["java","-jar","ecommerce.order.jar"]

