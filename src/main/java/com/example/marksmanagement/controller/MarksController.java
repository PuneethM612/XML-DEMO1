package com.example.marksmanagement.controller;

import com.example.marksmanagement.model.ExamType;
import com.example.marksmanagement.model.Marks;
import com.example.marksmanagement.model.Student;
import com.example.marksmanagement.model.Subject;
import com.example.marksmanagement.service.MarksService;
import com.example.marksmanagement.service.StudentService;
import com.example.marksmanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/marks")
public class MarksController {

    private final MarksService marksService;
    private final StudentService studentService;
    private final SubjectService subjectService;

    @Autowired
    public MarksController(MarksService marksService, StudentService studentService, SubjectService subjectService) {
        this.marksService = marksService;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @GetMapping
    public String getAllMarks(Model model) {
        List<Marks> marks = marksService.getAllMarks();
        model.addAttribute("marks", marks);
        return "marks";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("marks", new Marks());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("examTypes", ExamType.values());
        return "add-marks";
    }

    @PostMapping("/add")
    public String addMarks(@RequestParam String rollNumber, @RequestParam Long subjectId,
                         @RequestParam ExamType examType, @RequestParam Double marks,
                         RedirectAttributes redirectAttributes) {
        
        Optional<Student> student = studentService.getStudentByRollNumber(rollNumber);
        Optional<Subject> subject = subjectService.getSubjectById(subjectId);
        
        if (student.isPresent() && subject.isPresent()) {
            Marks marksObj = new Marks(student.get(), subject.get(), examType, marks);
            marksService.saveMarks(marksObj);
            redirectAttributes.addFlashAttribute("success", "Marks added successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Student or Subject not found!");
        }
        
        return "redirect:/marks";
    }

    @GetMapping("/search")
    public String searchMarksForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("examTypes", ExamType.values());
        return "search-marks";
    }

    @GetMapping("/search/results")
    public String searchMarks(@RequestParam String rollNumber, @RequestParam ExamType examType, Model model, RedirectAttributes redirectAttributes) {
        try {
            System.out.println("Searching marks for roll number: " + rollNumber + ", exam type: " + examType);
            
            // Get student first
            Optional<Student> student = studentService.getStudentByRollNumber(rollNumber);
            if (!student.isPresent()) {
                System.out.println("Student not found for roll number: " + rollNumber);
                redirectAttributes.addFlashAttribute("error", "Student not found for roll number: " + rollNumber);
                model.addAttribute("students", studentService.getAllStudents());
                model.addAttribute("examTypes", ExamType.values());
                return "redirect:/marks/search";
            }
            
            // Get marks for student and exam type
            List<Marks> marks = marksService.getMarksByStudentAndExamType(rollNumber, examType);
            System.out.println("Found " + (marks != null ? marks.size() : 0) + " marks for student");
            
            // Add all required attributes to the model
            model.addAttribute("marks", marks != null ? marks : Collections.emptyList());
            model.addAttribute("student", student.get());
            model.addAttribute("examType", examType);
            
            // Return the view name without layout reference
            return "marks-results";
        } catch (Exception e) {
            // Log the exception details for debugging
            System.err.println("Error in searchMarks: " + e.getMessage());
            e.printStackTrace();
            
            // Add error message and redirect to search page
            redirectAttributes.addFlashAttribute("error", "Error retrieving marks: " + e.getMessage());
            return "redirect:/marks/search";
        }
    }

    @GetMapping("/edit/{studentId}/{subjectId}/{examType}")
    public String showEditForm(@PathVariable String studentId, @PathVariable Long subjectId, 
                             @PathVariable ExamType examType, Model model) {
        
        Optional<Marks> marks = marksService.getMarksByStudentSubjectAndExamType(studentId, subjectId, examType);
        
        if (marks.isPresent()) {
            model.addAttribute("marks", marks.get());
            return "edit-marks";
        } else {
            return "redirect:/marks";
        }
    }

    @PostMapping("/edit")
    public String updateMarks(@ModelAttribute Marks marks) {
        marksService.updateMarks(marks);
        return "redirect:/marks";
    }

    // REST API endpoints

    @GetMapping("/api")
    @ResponseBody
    public List<Marks> getMarksApi() {
        return marksService.getAllMarks();
    }

    @GetMapping("/api/student/{rollNumber}")
    @ResponseBody
    public ResponseEntity<List<Marks>> getMarksByStudentApi(@PathVariable String rollNumber) {
        List<Marks> marks = marksService.getMarksByStudentRollNumber(rollNumber);
        if (marks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }

    @GetMapping("/api/student/{rollNumber}/exam/{examType}")
    @ResponseBody
    public ResponseEntity<List<Marks>> getMarksByStudentAndExamTypeApi(
            @PathVariable String rollNumber, @PathVariable ExamType examType) {
        
        List<Marks> marks = marksService.getMarksByStudentAndExamType(rollNumber, examType);
        if (marks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }

    @PostMapping("/api")
    @ResponseBody
    public ResponseEntity<Marks> createMarksApi(@RequestBody Marks marks) {
        Marks savedMarks = marksService.saveMarks(marks);
        return new ResponseEntity<>(savedMarks, HttpStatus.CREATED);
    }

    @PutMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Marks> updateMarksApi(@PathVariable Long id, @RequestBody Marks marks) {
        marks.setId(id);
        Marks updatedMarks = marksService.updateMarks(marks);
        return new ResponseEntity<>(updatedMarks, HttpStatus.OK);
    }

    @DeleteMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteMarksApi(@PathVariable Long id) {
        marksService.deleteMarks(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
} 