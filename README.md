# EMS-Application
# Employee Management System (EMS) with Spring Boot

## Overview

The Employee Management System (EMS) developed using Spring Boot, providing RESTful APIs for basic employee data management.

 Prerequisites:-

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 11 or later
- Maven
- Docker (optional, for containerization)

## Setup

1. Database Configuration

The application uses mySql database. If you prefer to use another database, update the `application.properties` file in `src/main/resources` accordingly.

2. Build the Application

you can run this application in any IDE in your local system.

he application will be accessible at http://localhost:8080/


3. API Documentation
API documentation is available using Swagger/OpenAPI. 
Access http://localhost:8080/swagger-ui/ to explore and interact with the API.

4. Testing
Unit Tests
	mvn test

5.Integration Tests
Integration tests are included in the src/test/java directory.

6. REST API Endpoints
The list of Employee having permission to fetch the data. Rest of the API's I have used spring Security( authentication), For rest of the Api's use Username & Password which is present in application.property file.

http://localhost:8080/employees/

List all employees: GET "/getAllEmployees"
Get a specific employee by ID: GET "/{id}"
Add a new employee: POST 
Update an existing employee: PUT "/{id}"
Remove an employee: DELETE "/{id}"

//  Advanced Features...

Get Employee by department: GET "/department/{department}"
Sort Employee by Joining Date: GET "/sorted"

7. API Documentation
Swagger: Access the Swagger UI and api-docs
localhost:8080/v2/api-docs
localhost:8080/swagger-ui/

8. Docker (Optional)
Docker file added in git.

docker build -t EMS .
docker run -p 8080:8080 EMS


