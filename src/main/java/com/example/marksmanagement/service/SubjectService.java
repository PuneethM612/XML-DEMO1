package com.example.marksmanagement.service;

import com.example.marksmanagement.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAllSubjects();
    
    Optional<Subject> getSubjectById(Long id);
    
    Subject saveSubject(Subject subject);
    
    void deleteSubject(Long id);
} 