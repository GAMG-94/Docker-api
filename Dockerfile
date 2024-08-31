FROM eclipse-temurin:21.0.4_7-jdk

WORKDIR /app

EXPOSE 8081

LABEL author="GAMG-94"

COPY pom.xml /app
COPY mvnw /app
COPY .mvn /app/.mvn

RUN ./mvnw dependency:go-offline

COPY ./src /app/src

RUN ./mvnw clean install -DskipTests

ENTRYPOINT ["java", "-jar", "/app/target/docker-api-0.0.1-SNAPSHOT.jar"]

