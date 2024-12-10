# Job Portal Application

## Project Overview  
The **Job Portal Application** is a robust platform designed to connect users to see companies, 
enabling them to explore job opportunities and check company reviews. Users can perform CRUD operations on jobs, 
reviews, and companies, offering a streamlined experience for job seekers and organizations alike. 
The application is built with a microservices architecture using Spring Boot, ensuring modularity, 
scalability, and maintainability. Service discovery is managed via Eureka Server, and inter-service 
communication is facilitated by OpenFeign. PostgreSQL is employed for database management, with Swagger providing comprehensive API documentation for seamless integration and testing.

---

## Architecture  
- **Spring Boot Microservices**: Separate services for managing jobs, reviews, and companies.  
- **Eureka Service Registry**: Facilitates service registration and discovery.  
- **OpenFeign**: Simplifies inter-service communication with declarative REST clients.  
- **Spring Cloud Gateway**: Routes and secures API requests to appropriate services.  
- **PostgreSQL**: Ensures reliable and persistent data storage.  
- **Swagger/OpenAPI**: Provides interactive API documentation and testing capabilities.

---

## Features  
### Job Management  
- Users can create, update, delete, and search for job listings.  
- Jobs are associated with companies via a **One-to-Many relationship**.  
- CRUD operations for jobs are implemented and documented with Swagger.

### Company Reviews  
- Users can read and write reviews for companies.  
- Reviews are linked to companies through a **One-to-Many relationship**.  
- Full CRUD functionality for reviews is available and documented.  

### Company Management  
- Companies can be added, updated, and deleted through a dedicated service.  
- Companies are the central entities associated with jobs and reviews.

### Inter-Service Communication  
- Services interact with one another seamlessly using Feign Client.  
- Service discovery and routing are managed by Eureka Server and Spring Cloud Gateway.

---


## Technical Implementation  
- **Job Service**: Manages job-related operations and CRUD functionalities.  
- **Review Service**: Handles CRUD operations for company reviews.  
- **Company Service**: Provides APIs for managing companies and their relationships with jobs and reviews.  
- **Eureka Service Registry**: Enables microservice registration and discovery.  
- **OpenFeign**: Used for declarative REST client communication between services.  
- **Spring Cloud Gateway**: Routes requests and ensures API security.  
- **PostgreSQL**: Database for persistent storage with JPA/Hibernate for ORM.  
- **Swagger/OpenAPI**: Interactive API documentation for all services.

---

![image](https://github.com/user-attachments/assets/7ad1ea4a-570a-499f-94e4-d5dfe666eb18)

---

# Hitting the Api Using GateWay 

---




![image](https://github.com/user-attachments/assets/6301e093-ad54-491b-9fe2-ef6cbd908e74)

---


## Hitting Job Api with their port No

---

 - **It Return Job Along with the company and review of their company.**

---

![image](https://github.com/user-attachments/assets/e5ba9d10-27c4-4f26-9e7f-f0d18d1d2954)


