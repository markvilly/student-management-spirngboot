package com.mark.studentmanagementsystem.student;

import org.springframework.stereotype.Service;

import com.mark.studentmanagementsystem.student.dto.CreateStudentRequest;
import com.mark.studentmanagementsystem.student.dto.UpdateStudentRequest;

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

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public Student patchStudent(Long id, UpdateStudentRequest req){
        Student existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Student with id " + id + " not found"));

                if(req.getFirstName() != null && req.getFirstName().isBlank()){
                    throw new BadRequestException("First Name should not be blank");
                }
                if(req.getLastName() != null && req.getLastName().isBlank()){
                    throw new BadRequestException("Last Name should not be blank");
                }

                if(req.getFirstName() != null){
                    existing.setFirstName(req.getFirstName());
                }

                if(req.getLastName() != null){
                    existing.setLastName(req.getLastName());
                }

                return existing;
    }

    public Student replaceStudent(Long id, CreateStudentRequest req){

        if(req.getFirstName() == null || req.getFirstName().isBlank()){
            throw new BadRequestException("First Name is required");
        }

        if(req.getLastName() == null || req.getLastName().isBlank()){
            throw new BadRequestException("Last Name is required");
        }


        Student existing = repo.findById(id)
                            .orElseThrow(()-> new NotFoundException("Student with id " + id + " is not found."));

        return existing;
    }



}
