# Etapa 1: Builder con Maven y Java 17
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /workspace

COPY pom.xml .
COPY src ./src

# Usa mvn directamente para compilar el proyecto
RUN mvn clean package -DskipTests

# Etapa 2: Runtime con Java 17
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
