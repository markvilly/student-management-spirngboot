package com.mark.studentmanagementsystem.auth;

import com.mark.studentmanagementsystem.student.BadRequestException;
import com.mark.studentmanagementsystem.auth.dto.LoginRequest;
import com.mark.studentmanagementsystem.auth.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    private final AppUserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthService(AppUserRepository repo, PasswordEncoder encoder, JwtService jwt){
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
    }
    
    public String register;

}
