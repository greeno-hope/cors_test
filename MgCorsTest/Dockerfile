# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/MgCorsTest*.jar /app/MgCorsTestApp.jar

# Expose the port the application will run on
EXPOSE 8088

# Specify the entry point to run the jar file
ENTRYPOINT m["java", "-Dspring.profiles.active=deploy", "-jar", "MgCorsTestApp.jar"]