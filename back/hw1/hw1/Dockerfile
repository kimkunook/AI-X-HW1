FROM openjdk:21-jdk

WORKDIR /app

ARG JAR_FILE=/build/libs/hw1-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]