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

    public String register(RegisterRequest req){
        if(repo.existsByEmail(req.getEmail())){
            throw new BadRequestException("Email already registered");
        }

        String role = req.getRole() == null || req.getRole().isBlank() ? "CLIENT" : req.getRole().toUpperCase();

        AppUser user = new AppUser(
            req.getEmail(),
            encoder.encode(req.getPassword()),
            role
        );
        repo.save(user);
        return jwt.generateToken(user.getEmail(), user.getRole());
    }

    public String login(LoginRequest req){
        AppUser user = repo.findByEmail(req.getEmail())
            .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!encoder.matches(req.getPassword(), user.getPasswordHash())){
            throw new BadRequestException("Invalid credentials");
        }

        return jwt.generateToken(user.getEmail(), user.getRole());
    }


}




