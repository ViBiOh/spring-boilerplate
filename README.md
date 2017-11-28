# spring-web-bp

[![Build Status](https://travis-ci.org/ViBiOh/spring-web-bp.svg?branch=master)](https://travis-ci.org/ViBiOh/spring-web-bp) [![](https://images.microbadger.com/badges/image/vibioh/spring-web-bp.svg)](https://microbadger.com/images/vibioh/spring-web-bp "Get your own image badge on microbadger.com")

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
  -v `pwd`:/usr/src/spring_web_bp \
  -w /usr/src/spring_web_bp \
  maven:3-jdk-8-alpine mvn spring-boot:run
```

### Docker image

```bash
docker-compose up -d
```