FROM maven:3.9.4-eclipse-temurin-21 AS backend-builder
WORKDIR /app

COPY pom.xml ./backend/
COPY /src ./backend/src

RUN mvn clean package -DskipTests -f backend/pom.xml

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the Spring Boot jar from the previous build stage
COPY --from=backend-builder /app/backend/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
