# Build stage
FROM eclipse-temurin:17-jdk-jammy AS builder
WORKDIR /app

# First copy only the files needed for Maven wrapper
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Download dependencies first (cached unless pom.xml changes)
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy source code and build
COPY src/ src/
RUN ./mvnw clean package

# Runtime stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]