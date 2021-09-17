FROM openjdk:17-slim

VOLUME /tmp
EXPOSE 8080

USER 65534

ENTRYPOINT [ "java", "-Xmx128m", "-Xss256k", "-jar", "/app.jar"]

COPY target/*.jar /app.jar
