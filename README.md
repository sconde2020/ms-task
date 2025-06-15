[![Build Status](https://2b42-2001-861-36c1-be50-9457-c497-14fa-d508.ngrok-free.app/job/ms-task-pipeline/badge/icon)](https://2b42-2001-861-36c1-be50-9457-c497-14fa-d508.ngrok-free.app/job/ms-task-pipeline/)

# ms-task

Backend part of task-manager application.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Overview

The **ms-task** repository contains the backend implementation of task-manager application. 
It is built using Java and follows best practices for backend development.

## Features

- User authentication and authorization
- CRUD operations for tasks
- Task categorization and prioritization
- Due date and reminder functionality
- RESTful API endpoints

## Technologies Used

- Java 21
- Spring Boot
- Maven
- Postgres
- H2 Database (for development purposes)

## Installation

### Prerequisites

- Java 17 or higher
- Maven

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/sconde2020/ms-task.git
   cd ms-task
   ```

2. Build the project:
    ```bash 
    mvn clean install
    ```

3. Build the project without tests:
    ```bash
    mvn clean install -DskipTests
    ```
   
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Usage
Once the application is running, you can access the API endpoints to manage tasks. The base URL is:

   ```bash
   http://localhost:9090/api/
   ```
Endpoints
- POST /tasks: Create a new task
- GET /tasks: Retrieve all tasks
- GET /tasks/{id}: Retrieve a task by ID
- PUT /tasks/{id}: Update a task
- DELETE /tasks/{id}: Delete a task
- Swagger: http://localhost:9090/swagger-ui/index.html#/

## Contributing
Contributions are welcome! Please fork the repository, create a new branch, and submit a pull request with your changes.

## License
This project is licensed under ... License.
