SHELL = /bin/bash

ifneq ("$(wildcard .env)","")
	include .env
	export
endif

APP_NAME = spring-web-bp

.DEFAULT_GOAL := app

## help: Display list of commands
.PHONY: help
help: Makefile
	@sed -n 's|^##||p' $< | column -t -s ':' | sort

## name: Output app name
.PHONY: name
name:
	@printf "$(APP_NAME)"

## version: Output last commit sha1
.PHONY: version
version:
	@printf "$(shell git rev-parse --short HEAD)"

## app: Build whole app
.PHONY: app
app: init build

## init: Bootstrap your application. e.g. fetch some data files, make some API calls, request user input etc...
.PHONY: init
init:
	@curl --disable --silent --show-error --location --max-time 30 "https://raw.githubusercontent.com/ViBiOh/scripts/main/bootstrap" | bash -s -- "-c" "git_hooks"

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
