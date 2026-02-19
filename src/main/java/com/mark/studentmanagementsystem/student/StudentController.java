package com.mark.studentmanagementsystem.student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mark.studentmanagementsystem.student.dto.CreateStudentRequest;
import com.mark.studentmanagementsystem.student.dto.UpdateStudentRequest;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@Valid @RequestBody CreateStudentRequest req){
        return service.createStudent(req);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return service.getStudent(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }

    @PatchMapping("/{id}")
    public Student patchStudent(@PathVariable Long id, @Valid @RequestBody Map<String, Object> updates){
        return service.patchStudent(id, updates);
    }

    @PutMapping("{id}")
    public Student putStudent(@PathVariable Long id, @Valid @RequestBody CreateStudentRequest req){
        return service.replaceStudent(id, req);
    }
}




