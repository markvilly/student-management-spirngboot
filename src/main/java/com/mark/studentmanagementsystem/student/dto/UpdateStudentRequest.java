package com.mark.studentmanagementsystem.student.dto;

import jakarta.validation.constraints.Pattern;


public class UpdateStudentRequest {
    @Pattern(regexp = ".*\\S.*", message = "First name cannot be blank")
    private String firstName;
    @Pattern(regexp = ".*\\S.*", message = "Last name cannot be blank")
    private String lastName;

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String fName){
        this.firstName = fName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lName){
        this.lastName = lName;
    }
    
}
