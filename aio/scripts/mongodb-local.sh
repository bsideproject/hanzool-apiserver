#!/usr/bin/env bash

sudo docker run \
  -d --rm --name=mongo \
  -e MONGO_INITDB_DATABASE=admin \
  -e MONGO_INITDB_ROOT_USERNAME=root \
  -e MONGO_INITDB_ROOT_PASSWORD=pass \
  -p 27017:27017 \
  mongo:4.4.4-bionic
