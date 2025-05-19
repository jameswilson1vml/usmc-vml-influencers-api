# USMC VML Influencers API

A Spring Boot REST API for managing USMC influencers and related data.

## Technologies

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- HSQLDB (embedded database)
- OpenAPI/Swagger Documentation
- Lombok
- Maven

## Prerequisites

- Java 17 or higher
- Maven 3.x

## Getting Started

1. Clone the repository:
```bash
git clone [repository-url]
cd usmc-vml-influencers-api
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Documentation

The API documentation is available via Swagger UI at:
- `http://localhost:8080/swagger-ui.html`

## Development

### Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/vml/usmc/influencers/
│   │       ├── model/         # Domain models
│   │       ├── repository/    # Data access layer
│   │       ├── service/       # Business logic
│   │       ├── controller/    # REST endpoints
│   │       └── config/        # Configuration classes
│   └── resources/
│       └── application.yml  # Application configuration
└── test/
    └── java/                  # Test classes
```

### Building

To build the project:
```bash
mvn clean package
```

### Testing

To run the tests:
```bash
mvn test
```