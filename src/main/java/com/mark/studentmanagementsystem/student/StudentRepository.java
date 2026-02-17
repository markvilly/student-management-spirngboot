package com.mark.studentmanagementsystem.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    
    private final List<Student> students = new ArrayList<>();

    public List<Student> findAll(){
        return students;
    }

    private long nextid = 1;

    public Student create (Student student){
        student.setId(nextid++);
        students.add(student);

        return student;
    }

    public boolean isEmpty(){
        return students.isEmpty();
    }

    public Optional<Student> findById(Long id){
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id){
        boolean removed = students.removeIf(s -> s.getId().equals(id));
        if(!removed){
            throw new NotFoundException("Student with id " + id + " not found ");
        }
    }
}
