package com.example.marksmanagement.repository;

import com.example.marksmanagement.model.ExamType;
import com.example.marksmanagement.model.Marks;
import com.example.marksmanagement.model.Student;
import com.example.marksmanagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
    List<Marks> findByStudent(Student student);
    
    List<Marks> findByStudentAndExamType(Student student, ExamType examType);
    
    Optional<Marks> findByStudentAndSubjectAndExamType(Student student, Subject subject, ExamType examType);
} 