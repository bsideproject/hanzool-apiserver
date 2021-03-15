# Sublink API Server

## 개발 환경

- Database

```bash
./scripts/mongodb-local.sh
```

- API Server

```bash
./gradlew bootRun
```

- Docker
```bash
#docker build
docker build -t hanzool/api-server .

#docker push
docker login
docker push hanzool/api-server

#docker run
docker run -p 8888:8888 hanzool/api-server
```

## Swagger

```bash
# http://localhost:8888/swagger-resources/
# http://localhost:8888/swagger-resources/configuration/ui
# http://localhost:8888/v2/api-docs
http://localhost:8888/swagger-ui.html
```
