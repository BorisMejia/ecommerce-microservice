package com.microservice.auth.infra.config;

import com.microservice.auth.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    @Value("${JWT_SECRET}")
    private String secretKey;

    @Value("${JWT_EXPIRATION}")
    private Long expirationKey;

    private byte[] getSigningKey() {
        return secretKey.getBytes(StandardCharsets.UTF_8);
    }

    public String generateToken(User user){
        return Jwts.builder()
                .setSubject(user.getIdUser().toString())
                .claim("userName", user.getUserName())
                .claim("email", user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationKey))
                .signWith(Keys.hmacShaKeyFor(getSigningKey()), SignatureAlgorithm.ES512)
                .compact();
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(getSigningKey()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token){
        try {
            extractAllClaims(token);
            return true;
        }catch (JwtException exception){
            return false;
        }
    }

    public String extractUserId(String token){
        return extractAllClaims(token).getSubject();
    }
}
