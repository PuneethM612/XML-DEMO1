package com.example.marksmanagement.repository;

import com.example.marksmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    // The string is the type of the ID field (roll number)
} 