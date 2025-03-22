#!/bin/bash
# Script to set up the Student Marks Management System project structure

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

echo "Project structure created successfully!"
echo "Now you need to populate the files with appropriate content."
echo "After that, you can run the application with: ./mvnw spring-boot:run" 