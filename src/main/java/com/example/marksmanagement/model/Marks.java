package com.example.marksmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "marks", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"roll_number", "subject_id", "exam_type"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marks {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "roll_number", nullable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "exam_type", nullable = false)
    private ExamType examType;
    
    @Column(nullable = false)
    private Double marks;
    
    // Optional constructor for convenience
    public Marks(Student student, Subject subject, ExamType examType, Double marks) {
        this.student = student;
        this.subject = subject;
        this.examType = examType;
        this.marks = marks;
    }
} 