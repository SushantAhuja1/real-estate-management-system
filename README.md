Real Estate Management System
A robust, enterprise-grade Spring Boot application designed to manage property listings. This project follows a strict 3-layer architecture and industry-standard design patterns to ensure scalability, security, and maintainability.

🛠 Tech Stack
Framework: Spring Boot 3.x

Language: Java 21

Database: PostgreSQL

Persistence: Spring Data JPA / Hibernate

Data Mapping: ModelMapper

Utilities: Lombok

🏗 Architecture & Design Patterns
The project is structured into distinct layers to promote a clear separation of concerns:

Presentation Layer (Controllers): Handles incoming HTTP requests and returns DTOs to the client (In Progress).

Service Layer: Contains the "business brain," handling logical operations and data transformation.

Persistence Layer (Repositories): Manages direct database communication using Spring Data JPA.

DTO Pattern: Data Transfer Objects (DTOs) are used to abstract the database schema from the API layer, preventing sensitive internal structures from being exposed.

Mapper Pattern: ModelMapper is used to automatically translate between Entities and DTOs.

🗄 Database Schema
The system manages a relational schema in PostgreSQL including:

Properties Table: Stores core property data (Address, Price, Type, Status, Owner, Description).

Collection Tables: Manages 1-to-Many relationships for Landmarks and Services using @ElementCollection.

🚀 Features Implemented (Service Layer)
Add Property: Accepts a DTO, maps to an Entity, persists to PostgreSQL, and returns the saved DTO with its generated ID.

List All Properties: Fetches all records and converts them into a list of DTOs for presentation.

Find by ID: Securely retrieves a specific property with built-in Exception Handling using .orElseThrow().

Custom Queries: Advanced repository methods for filtering by Owner Name, Property Type, and Availability Status.

🚦 How to Run
Configure your PostgreSQL database in src/main/resources/application.properties.

Ensure you have Java 21 and Maven installed.

Run the application via your IDE or using ./mvnw spring-boot:run.

The server starts on port 8082.