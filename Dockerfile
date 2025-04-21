FROM maven:3.9.4-eclipse-temurin-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/medicalstore-0.0.1-SNAPSHOT.jar medicalstore.jar
EXPOSE 8080
CMD ["java", "-jar", "medicalstore.jar"]
