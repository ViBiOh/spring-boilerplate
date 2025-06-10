FROM openjdk:26-slim

VOLUME /tmp

USER 65534

ENTRYPOINT [ "java", "-Xmx128m", "-Xss256k", "-jar", "/app.jar"]

COPY target/*.jar /app.jar
