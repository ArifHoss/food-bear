package com.foodbear.foodbear.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JwtGenerator implements Serializable {

    public String generateToken(String username){
        return Jwts.builder().setPayload(username)
                .setHeaderParam("type","JWT")
                .compact();
    }

}
