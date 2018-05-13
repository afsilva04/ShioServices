package com.shio.admin.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class SecurityUtils {

    public static final String SECRET = "ShioSecret";
    public static final long EXPIRATION_TIME = 43_200_000; // 12 hours
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String LOGIN_URL = "/users/login";

    public static String generateToken(String username, boolean admin, Long subsidiary) {
        return Jwts.builder()
                .setSubject(username)
                .claim("admin", admin)
                .claim("subsidiary", subsidiary)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
    }

}
