package com.mark.studentmanagementsystem.student.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateStudentRequest {
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Second name is required")
    private String lastName;

    public String getFirstName() {return firstName;};
    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastNamae(String lastName){this.lastName = lastName;} 

}


