package org.telran.social.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telran.social.entity.NetworkUser;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

//    @Value("${jwttoken.sign.secret.key}")
//    private String jjwtSingKey;

    private final SecretKey secretKey;

    public JwtService(@Value("${jwttoken.sign.secret.key}") String jjwtSingKey) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jjwtSingKey));
    }

    public String generateToken(NetworkUser networkUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", networkUser.getId());
        claims.put("login", networkUser.getLogin());
        claims.put("role", networkUser.getRole());

        return generateToken(claims, networkUser);
    }

    private String generateToken(Map<String, Object> claims, NetworkUser networkUser) {
        String token = Jwts.builder()
                .claims()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + (3600 * 1000)))
                .subject(networkUser.getLogin())
                .add(claims)
                .and()
                .signWith(secretKey)
                .compact();
        return token;
    }

    public String extractUserName(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    public boolean isTokenValid(String token) {
        Claims claims = extractAllClaims(token);
        Date expiration = claims.getExpiration();
        return expiration.after(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
