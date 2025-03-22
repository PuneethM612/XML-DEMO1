package com.example.marksmanagement.service;

import com.example.marksmanagement.model.Student;
import com.example.marksmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentByRollNumber(String rollNumber) {
        return studentRepository.findById(rollNumber);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String rollNumber) {
        studentRepository.deleteById(rollNumber);
    }
} 