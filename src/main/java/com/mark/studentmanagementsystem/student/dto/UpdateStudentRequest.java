package com.mark.studentmanagementsystem.student.dto;

import jakarta.validation.constraints.NotBlank;


public class UpdateStudentRequest {
    // @NotBlank(message = "First name cannot be blank")
    private String firstName;
    // @NotBlank(message = "Last name cannot be blank")
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
