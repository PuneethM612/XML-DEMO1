package com.example.marksmanagement.repository;

import com.example.marksmanagement.model.ExamType;
import com.example.marksmanagement.model.Marks;
import com.example.marksmanagement.model.Student;
import com.example.marksmanagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
    List<Marks> findByStudent(Student student);
    
    List<Marks> findByStudentAndExamType(Student student, ExamType examType);
    
    @Query("SELECT m FROM Marks m JOIN m.student s WHERE s.rollNumber = :rollNumber AND m.examType = :examType")
    List<Marks> findByStudent_RollNumberAndExamType(@Param("rollNumber") String rollNumber, @Param("examType") ExamType examType);
    
    Optional<Marks> findByStudentAndSubjectAndExamType(Student student, Subject subject, ExamType examType);
    
    @Query(value = "SELECT s.roll_number as rollNumber, s.name as studentName, SUM(m.marks) as totalMarks " +
            "FROM students s " +
            "JOIN marks m ON s.roll_number = m.student_id " +
            "WHERE m.exam_type = :examType " +
            "GROUP BY s.roll_number, s.name " +
            "ORDER BY totalMarks DESC " +
            "LIMIT 3", nativeQuery = true)
    List<Object[]> findTop3StudentsByExamType(@Param("examType") String examType);
    
    @Query(value = "SELECT s.roll_number as rollNumber, s.name as studentName, SUM(m.marks) as totalMarks " +
            "FROM students s " +
            "JOIN marks m ON s.roll_number = m.student_id " +
            "GROUP BY s.roll_number, s.name " +
            "ORDER BY totalMarks DESC " +
            "LIMIT 3", nativeQuery = true)
    List<Object[]> findTop3Students();
} 