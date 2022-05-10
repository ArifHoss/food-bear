package com.foodbear.foodbear.entities;

import org.springframework.security.core.GrantedAuthority;

public enum AuthorizationType implements GrantedAuthority {

    ADMIN, MANAGER, DELIVERY, CUSTOMER;

    @Override
    public String getAuthority() {
        return name();
    }
}
