# Hanzool API Server

## Development

- Database

```bash
sudo docker-compose --file=aio/mongo/docker-compose.yaml up --detach
```

- API Server

```bash
./gradlew bootRun
```

## API

- [swagger-ui](http://localhost:8888/swagger-ui/index.html)

```bash
curl http://localhost:8888/swagger-resources/
curl http://localhost:8888/swagger-resources/configuration/ui
curl http://localhost:8888/v3/api-docs
```

> Team Sublink
