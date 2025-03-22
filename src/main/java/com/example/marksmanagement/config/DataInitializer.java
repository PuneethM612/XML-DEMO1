package com.example.marksmanagement.config;

import com.example.marksmanagement.model.Subject;
import com.example.marksmanagement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final SubjectRepository subjectRepository;

    @Autowired
    public DataInitializer(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void run(String... args) {
        // Initialize subjects if none exist
        if (subjectRepository.count() == 0) {
            List<String> subjectNames = Arrays.asList(
                "Maths", 
                "Science", 
                "Marathi", 
                "Social", 
                "Kannada", 
                "Hindi", 
                "English"
            );
            
            for (String name : subjectNames) {
                Subject subject = new Subject();
                subject.setSubjectName(name);
                subjectRepository.save(subject);
            }
            
            System.out.println("Initialized default subjects: " + subjectNames);
        }
    }
} 