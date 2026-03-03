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
- Day 3: Cart and Order Module and Exception and ProductDTO

## Project Progress Update
### ✅ Modules Implemented

#### 👤 User Module
- User registration API implemented
- Service and repository layer added
- Basic validation included

#### 📦 Product Module
- Create product API
- Get all products API
- Introduced DTO layer (Request & Response)
- Clean separation between Entity and API response
#### 🛒 Cart Module
- Add to cart functionality
- Handles:
    - New cart creation for user
    - Adding new items
    - Updating quantity if item already exists
- Get cart API implemented

#### 📦 Order Module
- Place order functionality
- Flow includes:
    - Fetch cart items
    - Validate cart (not empty)
    - Validate product stock
    - Reduce stock after order
    - Create order and order items
    - Clear cart after order

---
