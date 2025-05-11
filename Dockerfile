# Build stage
FROM eclipse-temurin:17-jdk-jammy AS builder

# Install Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY . .
RUN mvn clean package
