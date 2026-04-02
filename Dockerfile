# Build stage
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn -f legacyexplorer/pom.xml clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/legacyexplorer/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
