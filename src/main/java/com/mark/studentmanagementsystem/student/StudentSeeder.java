package com.mark.studentmanagementsystem.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class StudentSeeder implements CommandLineRunner {

    private final StudentRepository repo;

    public StudentSeeder( StudentRepository repo){
        this.repo = repo;
    }

    @Override
    public void run(String... args){
        repo.create(new Student(null, "Mark", "Paul"));
        repo.create(new Student(null, "Paulo","Mabumba"));
        repo.create(new Student(null, "Shabaan", "Lazaak"));
    }
    
}
