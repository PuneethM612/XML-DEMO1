package com.example.marksmanagement.service;

import com.example.marksmanagement.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    
    Optional<Student> getStudentByRollNumber(String rollNumber);
    
    Student saveStudent(Student student);
    
    void deleteStudent(String rollNumber);
} 