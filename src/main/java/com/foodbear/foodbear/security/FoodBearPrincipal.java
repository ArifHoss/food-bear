package com.foodbear.foodbear.security;

import com.foodbear.foodbear.entities.AuthorizationType;
import com.foodbear.foodbear.entities.FoodBearUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class FoodBearPrincipal implements UserDetails {

    private final FoodBearUser foodBearUser;

    public FoodBearPrincipal(FoodBearUser foodBearUser) {
        this.foodBearUser = foodBearUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (AuthorizationType type :
                AuthorizationType.values()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(type.getAuthority()));
        }
        System.out.println(grantedAuthorities);
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.foodBearUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.foodBearUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
