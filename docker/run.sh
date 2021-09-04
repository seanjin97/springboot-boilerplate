#!/bin/sh

# This script does the following:
# 1. Reads config.env
# 2. Runs image with host system data folder binding and imported configs that will be read by application.properties

# change this value to your own docker repository. I'm using Github packages.
# this value will also be your image name
IMAGE_NAME=ghcr.io/seanjin97/springboottemplate:latest

docker run -it -d \
  --name springboottemplate \
  -p 8080:8080 \
  --env-file docker/config.env \
   "$IMAGE_NAME"
