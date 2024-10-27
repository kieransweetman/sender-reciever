
FROM maven:3.8.4-openjdk-11

WORKDIR /app
COPY pom.xml .
COPY src ./src

CMD ["mvn", "spring-boot:run"]
