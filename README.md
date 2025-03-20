# Spring-Secuity Exemplo
# Criar Usuario 
http://localhost:8080/users 
POST
Payload
``
{
    "email": "marcelo@email.coom",
    "password": "senha",
    "role": "ROLE_CUSTOMER"
}
``
# Autenticar
http://localhost:8080/users/login

Payload

``
{
    "email": "marcelo@email.coom",
    "password": "senha"
}
``

Resposta

`` 
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJwaXp6dXJnLWFwaSIsImlhdCI6MTc0MjQyOTM1MSwiZXhwIjoxNzQyNDQzNzUxLCJzdWIiOiJtYXJjZWxvQGVtYWlsLmNvb20ifQ.sAWvlQiNXqHeDwWK113TXEeimsawPzGYEnKbS_YvHVQ"
}
``


