SHELL = /usr/bin/env bash -o nounset -o pipefail -o errexit -c

ifneq ("$(wildcard .env)","")
	include .env
	export
endif

APP_NAME = spring-boilerplate

.DEFAULT_GOAL := app

## help: Display list of commands
.PHONY: help
help: Makefile
	@sed -n 's|^##||p' $< | column -t -s ':' | sort

## name: Output app name
.PHONY: name
name:
	@printf "$(APP_NAME)"

## version: Output last commit sha in short version
.PHONY: version
version:
	@printf "$(shell git rev-parse --short HEAD)"

## version-full: Output last commit sha
.PHONY: version-full
version-full:
	@printf "$(shell git rev-parse HEAD)"

## version-date: Output last commit date
.PHONY: version-date
version-date:
	@printf "$(shell git log -n 1 "--date=format:%Y%m%d%H%M" "--pretty=format:%cd")"

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
		--interactive \
		--tty \
		--rm \
		--name spring_web_bp \
		--volume "${PWD}:/usr/src/app" \
		--workdir /usr/src/app \
		"maven:3-openjdk-18-slim" mvn clean install

.PHONY: docker-run
docker-run:
	docker run \
		--interactive \
		--tty \
		--rm \
		--name spring_web_bp \
		--publish 8080:8080/tcp \
		--volume "${PWD}:/usr/src/app" \
		--workdir /usr/src/app \
		"maven:3-openjdk-18-slim" mvn spring-boot:run
