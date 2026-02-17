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
        if(req.getFirstName().isBlank() || req.getFirstName() == null){
            throw new BadRequestException("First name is required");
        }
        
        if(req.getLastName().isBlank() || req.getLastName() == null){
            throw new BadRequestException("Last name is required");
        }

        Student s = new Student(null, req.getFirstName(), req.getLastName());
        return repo.create(s);
    }

    public Student getStudent(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found"));
    }
}
