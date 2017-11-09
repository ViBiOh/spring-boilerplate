FROM openjdk:8-jre-alpine

HEALTHCHECK --retries=10 CMD wget -qO- http://localhost:8080/health
VOLUME /tmp
ENTRYPOINT [ "java", "-Xmx128m", "-Xss256k", "-jar", "/app.jar"]

COPY *.jar /app.jar
