# Use Java 17 runtime
FROM eclipse-temurin:17-jdk-jammy

# Set working dir
WORKDIR /app

# Copy the fat JAR built by Maven
COPY target/*.jar app.jar

# Expose the port your Spring Boot app listens on
EXPOSE 8081

# Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]
