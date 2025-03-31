package com.example.marksmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopRankerDTO {
    private String studentName;
    private String rollNumber;
    private Double totalMarks;
} 