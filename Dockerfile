FROM openjdk:21-jre-slim
EXPOSE 8080
COPY --from=build /target/CargaSinEstres-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]