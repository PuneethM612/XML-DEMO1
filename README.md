# Student Marks Management System

A comprehensive system to manage student marks and academic performance using Spring Boot and PostgreSQL.

## Features

- Manage Students (Add, View)
- Manage Subjects (Add, View)
- Manage Marks (Add, Edit, View)
- Search Marks by Student and Exam Type (Monthly, Mid-Term, Annual)
- Calculate Statistics (Average Marks)
- RESTful API endpoints for programmatic access

## Tech Stack

- Backend: Spring Boot 2.7.10, Spring Data JPA
- Database: PostgreSQL
- Frontend: Thymeleaf, Bootstrap 5, HTML, CSS
- Build Tool: Maven

## Database Schema

- **Students**: roll_number (PK), name
- **Subjects**: subject_id (PK), subject_name
- **Marks**: id (PK), roll_number (FK), subject_id (FK), exam_type, marks

## Setup & Installation

### Prerequisites

- Java 11+
- Maven
- PostgreSQL

### Database Setup

1. Create a PostgreSQL database named `marksmanagement`:

```sql
CREATE DATABASE marksmanagement;
```

2. Configure database connection in `src/main/resources/application.properties` if needed.

### Running the Application

1. Clone the repository:

```
git clone https://github.com/yourusername/student-marks-management.git
cd student-marks-management
```

2. Build the project:

```
./mvnw clean install
```

3. Run the application:

```
./mvnw spring-boot:run
```

4. Access the application at http://localhost:8080

## API Endpoints

### Student API

- `GET /students/api` - Get all students
- `GET /students/api/{rollNumber}` - Get student by roll number
- `POST /students/api` - Create new student
- `DELETE /students/api/{rollNumber}` - Delete student

### Subject API

- `GET /subjects/api` - Get all subjects
- `GET /subjects/api/{id}` - Get subject by ID
- `POST /subjects/api` - Create new subject
- `DELETE /subjects/api/{id}` - Delete subject

### Marks API

- `GET /marks/api` - Get all marks
- `GET /marks/api/student/{rollNumber}` - Get marks by student
- `GET /marks/api/student/{rollNumber}/exam/{examType}` - Get marks by student and exam type
- `POST /marks/api` - Create new marks
- `PUT /marks/api/{id}` - Update marks
- `DELETE /marks/api/{id}` - Delete marks

## License

MIT License
