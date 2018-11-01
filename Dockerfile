FROM openjdk:11-slim

HEALTHCHECK --retries=10 CMD wget -qO- http://localhost:8080/health
VOLUME /tmp
ENTRYPOINT [ "java", "-Xmx128m", "-Xss256k", "-jar", "/app.jar"]

EXPOSE 8080

COPY target/*.jar /app.jar
