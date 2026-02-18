package com.mark.studentmanagementsystem.student;

import org.springframework.stereotype.Service;

import com.mark.studentmanagementsystem.student.dto.CreateStudentRequest;
import com.mark.studentmanagementsystem.student.dto.UpdateStudentRequest;

import java.util.List;
import java.util.Set;
import java.util.Map;



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

    public Student getStudent(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found"));
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public Student patchStudent(Long id, Map<String, Object> updates){
        Student existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Student with id " + id + " not found"));


                // Optional: rejects unknown fields (good API hygiene)
                Set<String> allowed = Set.of("firstName", "lastName");
                for(String key: updates.keySet()){
                    if(!allowed.contains(key)){
                        throw new BadRequestException("Unknown field: " + key);
                    }
                }

                if(updates.containsKey("firstName")){
                    Object value = updates.get("firstName");

                    if(value == null){
                        //CLEAR FIELDS
                        existing.setFirstName(null);
                    }else if(value instanceof String s){
                        if(s.isBlank()) throw new BadRequestException("First name cannot be blank");
                        existing.setFirstName(s);
                    }else{
                        throw new BadRequestException("First name must be a string or null");
                    }
                }

                if(updates.containsKey("lastName")){
                    Object value = updates.get("lastName");

                    if(value == null){
                        existing.setLastName(null);
                    }else if(value instanceof String s){
                        if(s.isBlank()) throw new BadRequestException("Last name cannot be blank");
                        existing.setLastName(s);
                    }else{
                        throw new BadRequestException("Last name must be string or null");
                    }
                }

                return existing;
    }

    public Student replaceStudent(Long id, CreateStudentRequest req){

        Student existing = repo.findById(id)
                .orElseThrow(()-> new NotFoundException("Student with id " + id + " is not found."));

        existing.setFirstName(req.getFirstName());
        existing.setLastName(req.getLastName());
        
        return existing;
    }



}
