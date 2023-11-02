#Etapa de construcción
FROM openjdk:21-jdk AS build
WORKDIR /app
COPY pom.xml .
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package

#Etapa de ejecución
FROM openjdk:21-jdk
COPY --from=build TB2-backend-v2/CargaSinEstres/target/CargaSinEstres-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]