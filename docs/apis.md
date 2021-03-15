# 한줄평 API

- 회원가입

```bash
curl -H "Content-Type: application/json" -X POST -d '{"email": "imcxsu@gmail.com", "username":"sublink","password":"test"}' http://localhost:8888/api/users/signup
# {"id":"604f7235065698096e1f36d5","email":"imcxsu@gmail.com","username":"sublink","password":"test"}
```

- 회원 조회

```bash
curl -X GET http://localhost:8888/api/users/604f7235065698096e1f36d5
# {"id":"604f7235065698096e1f36d5","email":"imcxsu@gmail.com","username":"sublink","password":"test"}
```
