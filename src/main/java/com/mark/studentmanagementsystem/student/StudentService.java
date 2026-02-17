package com.mark.studentmanagementsystem.student;

import org.springframework.stereotype.Service;

import com.mark.studentmanagementsystem.student.dto.CreateStudentRequest;

import java.util.List;



@Service
public class StudentService {
    
    private final StudentRepository repo;

    public StudentService (StudentRepository repo){
        this.repo  = repo;
    }

    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    public Student createStudent(CreateStudentRequest req){
        Student s = new Student(null, req.getFirstName(), req.getLastName());
        return repo.create(s);
    }
}
