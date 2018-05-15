package com.shio.admin.security;

import io.jsonwebtoken.*;

import javax.servlet.http.HttpServletRequest;
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

    public static Long getSubsidiaryFromToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        String tokenClean = token.split(" ")[1];
        String[] split_string = tokenClean.split("\\.");

        Jwt<Header,Claims> parsedToken = Jwts.parser().parse(split_string[0] + "." + split_string[1] + ".");
        Long sub = new Long(parsedToken.getBody().get("subsidiary").toString());
        return sub;
    }

}
