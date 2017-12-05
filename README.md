# spring-web-bp

[![Build Status](https://travis-ci.org/ViBiOh/spring-web-bp.svg?branch=master)](https://travis-ci.org/ViBiOh/spring-web-bp)

[SonarCloud Report](https://sonarcloud.io/dashboard?id=spring-web-bp%3Aspring-web-bp)

## Building

```bash
mvn clean install
```

### With docker

```bash
docker run \
  -it \
  --rm \
  --name spring_web_bp \
  -v `pwd`:/usr/src/spring_web_bp \
  -w /usr/src/spring_web_bp \
  maven:3-jdk-8-alpine mvn clean install
```

## Running

```bash
mvn spring-boot:run
```

### With docker

```bash
docker run \
  -it \
  --rm \
  --name spring_web_bp \
  -p 8080:8080/tcp \
  -v `pwd`:/usr/src/spring_web_bp \
  -w /usr/src/spring_web_bp \
  maven:3-jdk-8-alpine mvn spring-boot:run
```

### Docker image

```bash
docker-compose up -d
```