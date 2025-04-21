# Use Java 17 LTS for compatibility with most platforms
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/medicalstore-0.0.1-SNAPSHOT.jar medicalstore.jar

CMD ["java", "-jar", "medicalstore.jar"]

EXPOSE 8080
