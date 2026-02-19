package com.mark.studentmanagementsystem.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
    @Email(message = "Email is invalid")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    
    @NotBlank(message="Password cannot be blank")
    @Size(min=6, message="Password must be at least 6 characters long")
    private String password;

    //for now optional
    private String role;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }
}
