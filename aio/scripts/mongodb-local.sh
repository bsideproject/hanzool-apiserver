#!/usr/bin/env bash

sudo docker run \
  -d --rm --name=mongo \
  -e MONGO_INITDB_DATABASE=testlocal \
  -e MONGO_INITDB_ROOT_USERNAME=admin \
  -e MONGO_INITDB_ROOT_PASSWORD=secret \
  -p 27017:27017 \
  mongo:4.4.4-bionic
