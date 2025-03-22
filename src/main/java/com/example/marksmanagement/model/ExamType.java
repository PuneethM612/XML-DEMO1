package com.example.marksmanagement.model;

public enum ExamType {
    MONTHLY("Monthly"),
    MID("Mid-Term"),
    ANNUAL("Annual");
    
    private final String displayName;
    
    ExamType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
} 