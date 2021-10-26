package com.alkemychallenge.disney.auth.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;

public class JwtUtils {
    private String SECRET_KEY = "secret";
    public String extractUsername(String token){
        return  extractClaim(token, Claims::getSubject);
    }
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    public<T> extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = exctractAllClaims(token);
        return  claimsResolver.apply(claims);
    }
    private Claims exctractAllClaims(String token){
        return jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims= new HashMap<>();
        return  createToken( claims, userDetails.getUsername());
    }
    public String createToken(Map<String, object> claims, String subject){
        return  jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.Hs256, SECRET_KEY).compact();
    public Boolean validateToken (String token){
        final String username= extractUsername(token, UserDetails userDetails);
        return  (username.equals(userDetails.getUserName())&& !isTokenExpired(token);
    }
}
