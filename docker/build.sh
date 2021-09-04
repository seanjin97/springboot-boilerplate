#!/bin/sh
./mvnw clean package -P container

# change this value to your own docker repository. I'm using Github packages.
# this value will also be your image name
IMAGE_NAME=ghcr.io/seanjin97/springboottemplate:latest
docker build -t "$IMAGE_NAME" .

docker push "$IMAGE_NAME"