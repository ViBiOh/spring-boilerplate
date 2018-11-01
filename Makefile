build:
	mvn clean install

start:
	mvn spring-boot:run

docker-build:
	docker run \
		-it \
		--rm \
		--name spring_web_bp \
		-v `pwd`:/usr/src/spring_web_bp \
		-w /usr/src/spring_web_bp \
		maven:3-jdk-11-slim mvn clean install

docker-start:
	docker run \
		-it \
		--rm \
		--name spring_web_bp \
		-p 8080:8080/tcp \
		-v `pwd`:/usr/src/spring_web_bp \
		-w /usr/src/spring_web_bp \
		maven:3-jdk-11-slim mvn spring-boot:run

.PHONY: build start docker-build docker-start
