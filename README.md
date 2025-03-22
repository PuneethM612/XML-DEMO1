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

# Create the main directory structure

mkdir -p src/main/java/com/example/marksmanagement/{controller,model,repository,service} src/main/resources/{static/css,templates,META-INF} src/main/resources/static/js

# Create the main application Java file

touch src/main/java/com/example/marksmanagement/MarksManagementApplication.java

# Create model classes

touch src/main/java/com/example/marksmanagement/model/Student.java
touch src/main/java/com/example/marksmanagement/model/Subject.java
touch src/main/java/com/example/marksmanagement/model/ExamType.java
touch src/main/java/com/example/marksmanagement/model/Marks.java

# Create repository interfaces

touch src/main/java/com/example/marksmanagement/repository/StudentRepository.java
touch src/main/java/com/example/marksmanagement/repository/SubjectRepository.java
touch src/main/java/com/example/marksmanagement/repository/MarksRepository.java

# Create service interfaces and implementations

touch src/main/java/com/example/marksmanagement/service/StudentService.java
touch src/main/java/com/example/marksmanagement/service/StudentServiceImpl.java
touch src/main/java/com/example/marksmanagement/service/SubjectService.java
touch src/main/java/com/example/marksmanagement/service/SubjectServiceImpl.java
touch src/main/java/com/example/marksmanagement/service/MarksService.java
touch src/main/java/com/example/marksmanagement/service/MarksServiceImpl.java

# Create controllers

touch src/main/java/com/example/marksmanagement/controller/HomeController.java
touch src/main/java/com/example/marksmanagement/controller/StudentController.java
touch src/main/java/com/example/marksmanagement/controller/SubjectController.java
touch src/main/java/com/example/marksmanagement/controller/MarksController.java

# Create resource files

touch src/main/resources/application.properties
touch src/main/resources/META-INF/beans.xml
touch src/main/resources/static/css/styles.css

# Create templates

touch src/main/resources/templates/layout.html
touch src/main/resources/templates/index.html
touch src/main/resources/templates/students.html
touch src/main/resources/templates/add-student.html
touch src/main/resources/templates/subjects.html
touch src/main/resources/templates/add-subject.html
touch src/main/resources/templates/marks.html
touch src/main/resources/templates/add-marks.html
touch src/main/resources/templates/edit-marks.html
touch src/main/resources/templates/search-marks.html
touch src/main/resources/templates/marks-results.html

# Create project files

touch pom.xml
touch .gitignore
touch README.md
