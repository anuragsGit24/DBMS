# The Banking Crew
A robust Spring Boot application for managing core banking operations, such as customer accounts, transactions, loans, and branches, with a RESTful API design and seamless database interactions using Spring Data JPA.

## Table of contents
-[Features](#features)
-[Useage](#useage)
-[GettingStarted](#getting started)
-[ProjectStructure](#project structure)
-[API](#api)
-[DatabaseSchema](#database schema)
-[License](#license)

## Features
Customer Management: CRUD operations for managing customer details.
Account Management: Tracks account details (balance, account type) and associates each with a customer.
Transaction Processing: Manages deposits and withdrawals, updating account balances.
Loan Management: Manages loans linked to specific accounts, with details like loan type and interest rate.
Employee Management: Tracks bank employees assigned to manage accounts.
Branch Management: Stores information on each bank branch and its location

## Useage
Java 21: Utilizes recent Java features and improvements.
Spring Boot: Framework for creating standalone applications with embedded server.
Spring Data JPA: Simplifies interactions with relational databases.
MapStruct: For mapping DTOs to entities and vice versa.
MySQL: Database for storing structured bank data.
Postman: For testing API endpoints.


