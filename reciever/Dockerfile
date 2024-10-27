# Use a Maven image with OpenJDK 11 for building and running the application
FROM maven:3.8.4-openjdk-11

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Run the application directly with Maven
CMD ["mvn", "spring-boot:run"]
