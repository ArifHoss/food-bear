package com.foodbear.foodbear.security;

import java.io.Serializable;

public class JwToken implements Serializable {

    private final String token;

    public JwToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
