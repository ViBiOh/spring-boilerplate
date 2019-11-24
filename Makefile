SHELL = /bin/bash

ifneq ("$(wildcard .env)","")
	include .env
	export
endif

## help: Display list of commands
.PHONY: help
help: Makefile
	@sed -n 's|^##||p' $< | column -t -s ':' | sed -e 's|^| |'

.PHONY: init
init:
	@curl -q -sSL --max-time 10 "https://raw.githubusercontent.com/ViBiOh/scripts/master/bootstrap" | bash -s "git_hooks"

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
