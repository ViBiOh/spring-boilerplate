FROM openjdk:16-slim

VOLUME /tmp
EXPOSE 8080

USER nobody

ENTRYPOINT [ "java", "-Xmx128m", "-Xss256k", "-jar", "/app.jar"]

COPY target/*.jar /app.jar
