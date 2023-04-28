package com.example.StudentApp.controller;

import com.example.StudentApp.entity.Student;
import com.example.StudentApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService studentService;

//    public List<Student> saveStudent(@RequestBody List<Student> students){
//        return studentService.saveStudent (students);
//    }
@PostMapping("/student")
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }
    @GetMapping("/{course}")
    public Long getStudentByCourse(@PathVariable String course) {
        return studentService.getStudentByCourse(course);
    }
    @GetMapping("address/{address}")
    public List<Student> getStudentByAddress(@PathVariable String address) {
        return studentService.getStudentByAddress(address);
    }
}
