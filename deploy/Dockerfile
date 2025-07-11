# Etapa 1: build con Maven + Java 11
FROM maven:3.9.4-eclipse-temurin-11 AS builder
WORKDIR /workspace

COPY pom.xml .
COPY src ./src

# Usa mvn directamente
RUN mvn clean package -DskipTests

# Etapa 2: runtime con Java 11
FROM eclipse-temurin:11-jre-alpine
WORKDIR /app
COPY --from=builder /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
