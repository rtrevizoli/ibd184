# Exemplo Avaliação Spring

## 1. POST `/trabalho` — Create a new Trabalho

### 1.1. Creating a new Trabalho with dataHoraEntrega

```Shell
curl -X POST http://localhost:8080/trabalho \
-H "Content-Type: application/json" \
-d "{ \
    \"titulo\": \"Trabalho de Geometria\", \
    \"grupo\": \"CoderHood\", \
    \"dataHoraEntrega\": \"2025-04-08T14:00:00\" \
    }"
```

### 1.2. Creating a new Trabalho without dataHoraEntrega

```Shell
curl -X POST http://localhost:8080/trabalho \
-H "Content-Type: application/json" \
-d "{ \
    \"titulo\": \"Trabalho de Politica\", \
    \"grupo\": \"CoderHood\" \
  }"
```

## 2. GET `/trabalho` — Get all Trabalho

 ```Shell
 curl http://localhost:8080/trabalho
 ```

##  3. GET `/trabalho/filtrar` — Search by palavra and notaMinima

### 3.1. Both params (palavra and notaMinima)

 ```Shell
curl "http://localhost:8080/trabalho/filtrar?palavra=Teste&notaMinima=2"
 ```

### 3.2. Only palavra as param

 ```Shell
 curl "http://localhost:8080/trabalho/filtrar?palavra=algoritmo"
 ```

### 3.3. Only notaMinima as param

 ```Shell
 curl "http://localhost:8080/trabalho/filtrar?notaMinima=5"
 ```

# Avaliação Spring

## 1. POST `/vaga` — Create a new Vaga

### 1.1. Creating new Vaga with an invalid tipo

```Shell
curl -X POST http://localhost:8080/vaga \
-H "Content-Type: application/json" \
-d "{ \
    \"tipo\": \"PJotizado\", \
    \"salario\": \"123456\" \
    }"
```

### 1.2. Creating new Vaga with a valid tipo

```Shell
curl -X POST http://localhost:8080/vaga \
-H "Content-Type: application/json" \
-d "{ \
    \"tipo\": \"PJ\", \
    \"salario\": \"656\" \
    }"
```

### 1.3. Creating new Vaga with an invalid dataTermino ( dataTermino lower than dataAbertura )
**Ps.:** dataAbertura is automatically set to the current time if not provided

```Shell
curl -X POST http://localhost:8080/vaga \
-H "Content-Type: application/json" \
-d "{ \
    \"tipo\": \"CLT\", \
    \"salario\": \"789\", \
    \"dataTermino\": \"2024-04-10\" \
    }"
```

### 1.4. Creating new Vaga with a valid dataTermino

```Shell
curl -X POST http://localhost:8080/vaga \
-H "Content-Type: application/json" \
-d "{ \
    \"tipo\": \"PJ\", \
    \"salario\": \"123456\", \
    \"dataTermino\": \"2026-04-10\" \
    }"
```
## 2. GET `/vaga` — Get all Vaga

```Shell
curl http://localhost:8080/vaga
```

## 3. GET `/vaga/filtrar` — Search by palavra or salarioMinimo

### 3.1. Both params (palavra and salarioMinimo)

```Shell
curl "http://localhost:8080/vaga/filtrar?palavra=java&salarioMinimo=7"
```
```Shell
curl "http://localhost:8080/vaga/filtrar?palavra=CLT&salarioMinimo=3301"
```

### 3.2. Only palavra as param

```Shell
curl "http://localhost:8080/vaga/filtrar?palavra=CLT"
```
```Shell
curl "http://localhost:8080/vaga/filtrar?palavra=PJ"
```

### 3.3 Only salarioMinimo as param

```Shell
$ curl "http://localhost:8080/vaga/filtrar?salarioMinimo=7"
```

```Shell
$ curl "http://localhost:8080/vaga/filtrar?salarioMinimo=123455
```