# spring-web-bp

[![Build](https://github.com/ViBiOh/spring-web-bp/workflows/Build/badge.svg)](https://github.com/ViBiOh/spring-web-bp/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ViBiOh_spring-web-bp&metric=alert_status)](https://sonarcloud.io/dashboard?id=ViBiOh_spring-web-bp)

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
  maven:3-jdk-11-alpine mvn clean install
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
  maven:3-jdk-11-alpine mvn spring-boot:run
```

### Docker image

```bash
docker-compose up -d
```
