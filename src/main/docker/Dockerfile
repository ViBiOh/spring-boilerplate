FROM vibioh/java

VOLUME /tmp
ENTRYPOINT [ "java", "-Xmx64m", "-Xss256k", "-jar", "/app.jar"]
HEALTHCHECK --retries=10 CMD wget -qO- http://localhost:8080/health
COPY *.jar /app.jar
