# Use an available, stable OpenJDK version
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/ATS.jar ATS.jar

# Expose the application port (1111 in this case, make sure your app is configured for this)
EXPOSE 1111

# Run the application
ENTRYPOINT ["java", "-jar", "/app/ATS.jar"]
