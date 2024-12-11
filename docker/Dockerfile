FROM openjdk:17

ARG APP_JAR=*.jar

COPY ${APP_JAR} docker.jar

ENTRYPOINT ["java", "-jar", "docker.jar"]

EXPOSE 8080