FROM openjdk:17
ADD target/monolitica-0.0.1-SNAPSHOT.jar monolitica-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "monolitica-0.0.1-SNAPSHOT.jar"]