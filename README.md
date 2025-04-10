# Airline RESTapi

## Description
This is a REST API built with Spring Boot that manages an airline booking system. The API provides endpoints for managing flights and reservations, implementing a complete CRUD (Create, Read, Update, Delete) functionality for both resources.

## Technologies Used
- Java 21
- Spring Boot 3.4.0
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## Structure
The project follows an architecture pattern with:

- Controllers: Handle HTTP requests
- Services: Implement business logic
- Repositories: Access data
- Models: Define entity structure
- DTOs: Data Transfer Objects for API responses
- Exceptions: Custom exception handling

## Features
- Flight management (create, read, update, delete)
- Reservation management (create, read, update, delete)
- Error handling with custom exceptions
- CORS configuration for frontend integration
- Data Transfer Objects for clean API responses

## Database Setup
The project uses PostgreSQL for data storage. You can find the database creation script in **databaseExample.txt** which includes:
- Tables for users, flights, reservations, and payments
- Sample data for testing

To set up the database:

1. Create a PostgreSQL database
1. Execute the SQL commands from **databaseExample.txt**
1. Configure the connection in **application.properties**

## API Endpoints
Flight Endpoints:
- **GET /flights**: Retrieve all flights
- **GET /flight/{id}**: Retrieve a specific flight
- **POST /flight**: Create a new flight
- **PUT /flight/{id}**: Update an existing flight
- **DELETE /flight/{id}**: Delete a flight
Flight Endpoints:
- **GET /reservation**: Retrieve all reservation
- **GET /reservation/{id}**: Retrieve a specific reservation
- **POST /reservation**: Create a new reservation
- **PUT /reservation/{id}**: Update an existing reservation
- **DELETE /reservation/{id}**: Delete a reservation

## Frontend
A simple frontend implementation is included in the FrontendJavaProject directory, featuring:
- Flight listing interface
- Forms for creating and updating flights
- Option to delete a flight

## Setup instructions
### Prerequisites: 
- JDK 21 or later
- PostgreSQL
- Maven (or use the included Maven wrapper)

### Configuration:
1. Configure database connection in **application.properties**:
*spring.datasource.url=jdbc:postgresql://localhost:port/name*  
*spring.datasource.username=your_username*  
*spring.datasource.password=your_password*  
1. The API runs on port **3001** by default. You can change this in the **application.properties** file.

### Running the app:
You can run using:
- ./mvnw spring-boot:run
- mvnw.cmd spring-boot:run

## Author
Implemented by: **Popa Marian-Iulian**