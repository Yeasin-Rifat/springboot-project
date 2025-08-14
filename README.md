## 🚀 Spring Boot REST API with Secure Access

A simple yet powerful Spring Boot application that demonstrates how to build a RESTful API with secure, role-based access. It features HTTP Basic Authentication, role-based authorization, and integrates with a PostgreSQL database using Spring Data JPA.

---

### ✅ Features

- 🔐 **Secure Login**: Basic authentication using username and password
- 👥 **Role-Based Access Control**: Endpoints restricted by roles (`USER`, `ADMIN`)
- 🔒 **Password Encryption**: Passwords hashed using BCrypt before storing
- 🐘 **PostgreSQL Integration**: Connects to a PostgreSQL database named `intern_db`
- 👤 **Auto-Loaded Default Users**: Two users (`intern`, `admin`) added at startup
- 🌐 **RESTful API Endpoints**: Public and protected endpoints for different access levels

---

### 🛠️ Getting Started

#### ✅ Prerequisites

Ensure the following are installed:

- Java 17 or higher
- Maven
- PostgreSQL

---

### 🗄️ Database Setup

#### 1. Create the Database

Run this in your PostgreSQL environment:

```sql
CREATE DATABASE intern_db;

```

#### 2️⃣ Configure Database Connection

Update the `src/main/resources/application.properties` file with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/intern_db
spring.datasource.username=your_username       # e.g., 'postgres'
spring.datasource.password=your_password       # e.g., '12345'
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```

### ▶️ Running the Application
Use Maven to start the server:
```
mvn spring-boot:run
```

### 👥 Default Users

These users are auto-created at startup:

| Username | Password     | Role  |
|----------|--------------|-------|
| intern   | password123  | USER  |
| admin    | admin123     | ADMIN |


### 🌐 API Endpoints

| Method | Endpoint   | Description                          | Access Level     |
|--------|------------|--------------------------------------|------------------|
| GET    | `/public`  | Public endpoint — no login required | Open to everyone |
| GET    | `/user`    | For logged-in users (USER/ADMIN)     | Authenticated    |
| GET    | `/admin`   | For admin users only                 | ADMIN only       |
| POST   | `/users`   | Create a new user (admin only)       | ADMIN only       |


### 📥 Example: Create New User

To create a new user via `POST /users`, send a JSON body like this (authenticated as an admin):

```json
{
  "username": "newuser",
  "password": "newpass",
  "role": "USER"
}
``` 

### 📝 Assumptions

- The application assumes your PostgreSQL server is running locally.
- Only admins are allowed to create new users via the `/users` endpoint.
- Passwords are always encrypted before saving to the database.

---

### 📎 Project Link

🔗 https://github.com/Yeasin-Rifat/springboot-project.git

