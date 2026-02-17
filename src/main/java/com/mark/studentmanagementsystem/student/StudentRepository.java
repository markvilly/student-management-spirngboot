package com.mark.studentmanagementsystem.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    
    private final List<Student> students = new ArrayList<>(
        List.of(
        new Student(1L, "Mark", "Paul"),
        new Student(2L, "Asha", "Mrema"),
        new Student(3L, "Juma", "Kweka")
        )
    );

    public List<Student> findAll(){
        return students;
    }

    private long nextid = 4;

    public Student create (Student student){
        student.setId(nextid++);
        students.add(student);

        return student;

    }

    public Optional<Student> findById(Long id){
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }
}
