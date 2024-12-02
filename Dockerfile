#Use official OpenJDK 17 image from Docker Hub
FROM openjdk:17

#Set working directory inside the container
WORKDIR /app

#Copy the compiled Java application JAR file into the container
EXPOSE 8080

#Command to run the application
CMD["java", "-jar", "api_productos.jar"]