#E -commerce BackEnd(Spring Boot)

## Description
This is a backend application that using Spring Boot.Currently it supports 
- user registration functionality
- Product Management

## Tech Stack
- Java
- Spring Boot
- JPA
- H2 Database
- Maven
- Swagger/Postman

## API Overview

### User APIs
- POST /users/register

### Product APIs
- POST /products/create
- GET /products/all

# Request
```json
{
"name":"Basil",
"email":"abc@gmail.com",
"password":"USER@123"
}
```
## Author
Basil

## Progress
- Day 1: User Registration
- Day 2: Product Module(Create +Get)