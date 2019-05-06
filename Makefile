.PHONY: build
build:
	mvn clean install

.PHONY: start
start:
	mvn spring-boot:run

.PHONY: docker-build
docker-build:
	docker run \
		-it \
		--rm \
		--name spring_web_bp \
		-v $(pwd):/usr/src/spring_web_bp \
		-w /usr/src/spring_web_bp \
		maven:3-jdk-11-slim mvn clean install

.PHONY: docker-start
docker-start:
	docker run \
		-it \
		--rm \
		--name spring_web_bp \
		-p 8080:8080/tcp \
		-v $(pwd):/usr/src/spring_web_bp \
		-w /usr/src/spring_web_bp \
		maven:3-jdk-11-slim mvn spring-boot:run
