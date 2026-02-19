package com.mark.studentmanagementsystem.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwrService {
    
    private static final String SECRET = "CHANGE_ME_CHANGE_ME_CHANGE_ME_123456";

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String email, String role){
        long now = System.currentTimeMillis();
        return Jwts.builder()
        .subject(email)
        .claim("role", role)
        .issuedAt(new Date(now))
        .expiration(new Date(now + 1000L * 60 * 60 * 10))
        .signWith(key)
        .compact();
    }
}
