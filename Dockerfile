FROM maven:3.8.5-openjdk:21-jdk
COPY --from=build TB2-backend-v2/CargaSinEstres/target/CargaSinEstres-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]