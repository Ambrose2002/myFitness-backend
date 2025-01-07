# myFitness Backend

This is the backend API for the **myFitness** iOS app. The backend is responsible for handling user data, workouts, diet tracking, and other fitness-related functionalities. It is built using **Spring Boot**, **Kotlin**, **Spring Data JPA**, and **MySQL** for production.

## Table of Contents

- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Endpoints](#endpoints)
- [Running the Project](#running-the-project)
- [Database](#database)
- [Contributing](#contributing)

## Technologies

This project uses the following technologies:

- **Spring Boot**: A framework for building Java-based backend applications.
- **Kotlin**: The programming language used for writing the backend code.
- **Spring Data JPA**: For interacting with the relational database (MySQL or PostgreSQL).
- **Spring Security**: For securing the REST API endpoints (planned for future implementation).
- **H2 Database**: For development (in-memory database).
- **MySQL/PostgreSQL**: For production database.
- **Lombok**: For reducing boilerplate code in Kotlin.
- **Gradle**: The build tool used to manage dependencies and packaging.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- **Java 17+** (preferably) for building and running the project.
- **Gradle** (or **Maven**) for building the project.
- **MySQL** or **PostgreSQL** for production (ensure the database server is running).
- **IntelliJ IDEA** or any preferred IDE that supports Kotlin and Spring Boot.

### Installation

1. Clone this repository:

    ```bash
    git clone https://github.com/your-username/myfitness-backend.git
    cd myfitness-backend
    ```

2. Open the project in your IDE (e.g., IntelliJ IDEA).

3. Configure the database connection in `src/main/resources/application.properties` for your MySQL or PostgreSQL setup.

4. Build the project using Gradle or Maven:

    For Gradle:
    ```bash
    ./gradlew build
    ```

    For Maven:
    ```bash
    mvn clean install
    ```

5. Run the project:

    For Gradle:
    ```bash
    ./gradlew bootRun
    ```

    For Maven:
    ```bash
    mvn spring-boot:run
    ```

The API will now be running at `http://localhost:8080`.

## Project Structure

### Key Folders and Files:
- **controller**: Contains the REST controllers which handle HTTP requests like creating and getting users, workouts, and other fitness data.
- **model**: Contains entity classes, including User, Workout, and other business objects mapped to the database.
- **repository**: Contains the interfaces for interacting with the database, such as finding users by ID, saving workouts, etc. These interfaces extend Spring Data JPA's `JpaRepository` or `CrudRepository`.
- **service**: Contains classes with business logic that interact with repositories and perform necessary operations on the data.
- **MyFitnessBackendApplication.kt**: The main entry point of the application, where the Spring Boot application is bootstrapped.


## Endpoints
#### loading...


## Running the Project

To run the project locally, follow these steps:

1. Clone the repository.
2. Install dependencies using Gradle or Maven.
3. Configure your database connection in `src/main/resources/application.properties` (using MySQL or PostgreSQL).
4. Run the application with Gradle or Maven commands as shown above.
5. The backend will be available at `http://localhost:8080`.

## Database

This project uses a relational database (MySQL or PostgreSQL) for persistent storage. Below are the instructions for setting up the database connection for each option.

### Database Configuration

The database connection is configured in the `application.properties` file located in the `src/main/resources` directory. You can choose between MySQL or PostgreSQL as the database for your project.

#### MySQL Configuration

If you are using MySQL, update the `application.properties` file with the following configuration:

```properties
# MySQL database connection settings
spring.datasource.url=jdbc:mysql://localhost:3306/myfitness_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Optional: To set the default timezone for MySQL
spring.datasource.tomcat.timezone=UTC

```

## Contributing

We welcome contributions to **MyFitness**!

