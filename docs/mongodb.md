# 테스트 몽고DB 컨테이너

## startup

```bash
sudo docker-compose --file=aio/mongo/docker-compose.yaml up --detach
sudo docker exec -it mongo bash
```

```bash
mongo
use testlocal
db.auth('user', 'pass')
```

## cleanup

```bash
sudo docker-compose --file=aio/mongo/docker-compose.yaml down
```

## Mongo Express

- [localhost:8081](http://localhost:8081)
