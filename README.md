# The Banking Crew

A robust Spring Boot application for managing core banking operations, such as customer accounts, transactions, loans, and branches, with a RESTful API design and seamless database interactions using Spring Data JPA.




## Features

- Customer Management
- Account Management
- Branch Management
- Transaction Management
- Loan Management
- Employee Management
- Fixed Deposit Management

## Technologies Used

- Java 21: Utilizes recent Java features and improvements.
- Spring Boot: Framework for creating standalone applications with embedded server.
- Spring Data JPA: Simplifies interactions with relational databases.
- MySQL: Database for storing structured bank data.
- Postman: For testing API endpoints.

# Getting Started
## Prerequisites
- Java 21 installed
- MySQL database setup with an empty schema
- Postman for testing API endpoints (optional but recommended)


## Clone the repository


```bash
git clone https://github.com/your-username/bank-database-management-system.git
cd bank-database-management-system
```
## Database Configuration
- Open src/main/resources/application.properties.
- Set Up mysql credentials
```bash 
spring.datasource.url=jdbc:mysql://localhost:3306/bank_management
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update
```
## Run the application
```bash
./mvnw spring-boot:run
```
- The API will be accessible at http://localhost:8080/api


