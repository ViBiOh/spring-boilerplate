FROM openjdk:16-slim

VOLUME /tmp
EXPOSE 8080

RUN useradd --shell /bin/bash --system --no-create-home --no-user-group --uid 1000 app
USER app

ENTRYPOINT [ "java", "-Xmx128m", "-Xss256k", "-jar", "/app.jar"]

COPY target/*.jar /app.jar
