package com.example.marksmanagement.controller;

import com.example.marksmanagement.model.Student;
import com.example.marksmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // REST API endpoints for programmatic access

    @GetMapping("/api")
    @ResponseBody
    public List<Student> getStudentsApi() {
        return studentService.getAllStudents();
    }

    @GetMapping("/api/{rollNumber}")
    @ResponseBody
    public ResponseEntity<Student> getStudentApi(@PathVariable String rollNumber) {
        Optional<Student> student = studentService.getStudentByRollNumber(rollNumber);
        return student
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/api")
    @ResponseBody
    public ResponseEntity<Student> createStudentApi(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/{rollNumber}")
    @ResponseBody
    public ResponseEntity<Void> deleteStudentApi(@PathVariable String rollNumber) {
        studentService.deleteStudent(rollNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
} 