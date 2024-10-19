FROM openjdk:17-alpine

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

LABEL authors="engacleciocruz"

ENTRYPOINT ["java", "-jar", "app.jar"]