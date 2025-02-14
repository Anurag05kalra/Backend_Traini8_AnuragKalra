# Traini8-govt-training-center

## Project Overview
This project is an MVP for a Government-Funded Training Center Registry that allows users to register training centers with details such as name, address, courses offered, and contact information. It is built using Spring Boot, Spring Data JPA, and MySQL.

## Features
 * Create and store training center details.
 * Validate inputs using spring validation .
 * Automatically generate timestamps for center creation.
 * store course offerings in JSON format.
 * RESTful API with proper request and response handling.

## Tech Stack
 * Backend : Java, Spring Boot
 * Database : MySQL
 * Validation : Jakarta Validation
 * API Handling : Spring REST Controller
 * Build Tool : Maven
 * Lombok : Reducing Boilerplate Code
 * Postman : API Testing 

## Setup Instructions
1. Prerequisites
  Ensure you have the following installed:
  * Java JDK 19
  * Spring Tool Suite (STS) or IntelliJ IDEA
  * MySQL Server
  * Postman (for testing APIs)
  * Git (for version control)

2. Clone the Repository
 ```
 git clone https://github.com/Anurag05kalra/Traini8-govt-training-center.git
```
3. Configure the Database
  * Create a new MySQL database:
  ```
  CREATE DATABASE traini8;
  ```
* Update application.properties file inside src/main/resources/:
 ```
  spring.application.name=MVP
  spring.datasource.url=jdbc:mysql://localhost:3306/traini8?serverTimezone=UTC
  spring.datasource.username=root
  spring.datasource.password=password
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true
  server.port=8084
 ```
4. Build & Run the Application
  ```
  mvn clean install
  mvn spring-boot:run
 ```
Using STS/IntelliJ:
* open the Project
* Navigate to MvpApplication.java
* click run

5. API Endpoints
 1. Create New Training Center 
* Method : POST
* URL: /training-center
* Request Body (JSON Example):
 ```
  {
    "centerName": "Code Masters Academy",
    "centerCode": "CMA7890",
    "address": {
        "detailedAddress": "MG Road, IT Park",
        "city": "Bengaluru",
        
        "state": "Karnataka",
        "pincode": "560001"
    },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Spring Boot", "Microservices"],
    "contactEmail": "contact@codemasters.com",
    "contactPhone": "9876543210"
 }
```
* Response Example:
```
 {
    "id": 5,
    "centerName": "Code Masters Academy",
    "centerCode": "CMA7890",
    "address": {
        "detailedAddress": "MG Road, IT Park",
        "city": "Bengaluru",
        "state": "Karnataka",
        "pincode": "560001"
    },
    "studentCapacity": 200,
    "createdOn": 1739521046797,
    "contactEmail": "contact@codemasters.com",
    "contactPhone": "9876543210",
    "coursesOffered": [
         "Java",
        "Spring Boot",
        "Microservices"
    ]
 }
```
2.Get All Training Centers
* Method : GET
* URL : /training-center/all
* Response Example:
 ```
  [
    {
        "id": 1,
        "centerName": "ABC Training Center",
        "centerCode": "ABC123XYZ456",
        "address": {
            "detailedAddress": "Street 123, XYZ City",
            "city": "XYZ",
            "state": "ABC",
            "pincode": "123456"
        },
        "studentCapacity": 100,
        "createdOn": 1739447954574,
        "contactEmail": "abc@example.com",
        "contactPhone": "9876543210",
        "coursesOffered": [
            "Java",
            "Python",
            "DSA"
        ]
    },
    {
        "id": 2,
        "centerName": "Tech Academy",
        "centerCode": "TECH123XZ8",
        "address": {
            "detailedAddress": "123 Tech Street",
            "city": "New York",
            "state": "NY",
            "pincode": "100018"
        },
        "studentCapacity": 50,
        "createdOn": 1739448677417,
        "contactEmail": "techacademy@example.com",
        "contactPhone": "9876543210",
        "coursesOffered": [
            "Java",
            "Python",
            "Web Development"
        ]
    },
    {
        "id": 3,
        "centerName": "Tech Learning Hub",
        "centerCode": "TLH4567",
        "address": {
            "detailedAddress": "Sector 22, ABC Colony",
            "city": "New Delhi",
            "state": "Delhi",
            "pincode": "110001"
        },
        "studentCapacity": 150,
        "createdOn": 1739449117997,
        "contactEmail": "techhub@example.com",
        "contactPhone": "9123456789",
        "coursesOffered": [
            "React",
            "Angular",
            "Node.js"
        ]
    },
    {
        "id": 4,
        "centerName": "Code Masters Academy",
        "centerCode": "CMA7890",
        "address": {
            "detailedAddress": "MG Road, IT Park",
            "city": "Bengaluru",
            "state": "Karnataka",
            "pincode": "560001"
        },
        "studentCapacity": 200,
        "createdOn": 1739465133871,
        "contactEmail": "contact@codemasters.com",
        "contactPhone": "9876543210",
        "coursesOffered": [
            "Java",
            "Spring Boot",
            "Microservices"
        ]
    },
    {
        "id": 5,
        "centerName": "Code Masters Academy",
        "centerCode": "CMA7890",
        "address": {
            "detailedAddress": "MG Road, IT Park",
            "city": "Bengaluru",
            "state": "Karnataka",
            "pincode": "560001"
        },
        "studentCapacity": 200,
        "createdOn": 1739521046797,
        "contactEmail": "contact@codemasters.com",
        "contactPhone": "9876543210",
        "coursesOffered": [
            "Java",
            "Spring Boot",
            "Microservices"
         ]
     }
   ]
 ```


