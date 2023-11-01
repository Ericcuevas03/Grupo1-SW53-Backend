#
# Build stage
#
FROM maven:4.0.0-jdk-21-slim AS build
COPY . .
COPY pom.xml /home/app
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:21-jre-slim
COPY --from=build /home/app/target/CargaSinEstres-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]