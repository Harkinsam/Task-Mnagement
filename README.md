# Task Manager API

A robust Task Management API built with Spring Boot that provides endpoints for user management, task tracking, and more.

## Technology Stack

- **Backend Framework**: Spring Boot 3.x
- **Build Tool**: Maven
- **Java Version**: 17+
- **Database**: H2 (in-memory, for development)
- **API Documentation**: SpringDoc OpenAPI 3.0 (Swagger UI)
- **Testing**: JUnit, Mockito
- **Validation**: Bean Validation API

## Prerequisites

- JDK 17 or later
- Maven 3.6.0 or later
- (Optional) Your preferred IDE (IntelliJ IDEA, Eclipse, etc.)

## Building the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/Harkinsam/Task-Mnagement.git
   cd taskmanager
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Running the Application

You can run the application using one of the following methods:

### Using Maven
```bash
mvn spring-boot:run
```

### Using the packaged JAR
```bash
mvn package
java -jar target/taskmanager-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080` by default.

## Accessing Swagger UI

Once the application is running, you can access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

This provides interactive API documentation where you can test all available endpoints.

## API Endpoints

- **User Management**:
  - `POST /api/users` - Create a new user
  - `GET /api/users/{id}` - Get user by ID

- **Task Management**:
  - `POST /api/tasks` - Create a new task
  - `GET /api/tasks/{id}` - Get task by ID
  - `PUT /api/tasks/{id}` - Update task
    

## Design Decisions

1. **Layered Architecture**: The application follows a clean architecture with clear separation of concerns:
   - Controllers for handling HTTP requests
   - Services for business logic
   - Repositories for data access
   - DTOs for data transfer between layers

2. **Error Handling**: Comprehensive error handling with appropriate HTTP status codes and meaningful error messages.

3. **Validation**: Input validation using Bean Validation API to ensure data integrity.

4. **Pagination**: List endpoints support pagination for better performance with large datasets.

5. **API Documentation**: Integrated Swagger UI for interactive API documentation.

6. **Testing**: Comprehensive test coverage with unit and integration tests.

## Assumptions

1. The application uses an in-memory H2 database by default for development purposes.
2. For production, you would typically configure a persistent database like PostgreSQL or MySQL.
3. Authentication and authorization are not implemented in the current version but can be added using Spring Security.

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
