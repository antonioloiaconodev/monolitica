FROM openjdk:17
ADD target/monolitica-0.0.1-SNAPSHOT.jar monolitica-0.0.1-SNAPSHOT.jar
EXPOSE "${SERVER_PORT}"
ENTRYPOINT ["java", "-jar", "monolitica-0.0.1-SNAPSHOT.jar"]