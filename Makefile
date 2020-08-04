SHELL = /bin/bash

ifneq ("$(wildcard .env)","")
	include .env
	export
endif

## help: Display list of commands
.PHONY: help
help: Makefile
	@sed -n 's|^##||p' $< | column -t -s ':' | sort

## init: Bootstrap your application. e.g. fetch some data files, make some API calls, request user input etc...
.PHONY: init
init:
	@curl -q -sSL --max-time 30 "https://raw.githubusercontent.com/ViBiOh/scripts/master/bootstrap" | bash -s "git_hooks"

## build: Build the application.
.PHONY: build
build:
	mvn clean install

## run: Locally run the application, e.g. node index.js, python -m myapp, go run myapp etc ...
.PHONY: run
run:
	mvn spring-boot:run

.PHONY: docker-build
docker-build:
	docker run \
		-it \
		--rm \
		--name spring_web_bp \
		-v "$(pwd):/usr/src/app" \
		-w /usr/src/app \
		maven:3-jdk-11-slim mvn clean install

.PHONY: docker-run
docker-run:
	docker run \
		-it \
		--rm \
		--name spring_web_bp \
		-p 8080:8080/tcp \
		-v "$(pwd):/usr/src/app" \
		-w /usr/src/app \
		maven:3-jdk-11-slim mvn spring-boot:run
