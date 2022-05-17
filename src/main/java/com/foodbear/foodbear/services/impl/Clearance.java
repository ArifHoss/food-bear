package com.foodbear.foodbear.services.impl;

import com.foodbear.foodbear.entities.pojos.FoodBearUser;
import com.foodbear.foodbear.exception.ResourceNotFoundException;
import com.foodbear.foodbear.repo.FoodBearUserDaoJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Clearance {

    private final FoodBearUserDaoJpa userDaoJpa;

    public FoodBearUser getCurrentTokenUser(){
        Optional<FoodBearUser> user = userDaoJpa.findfoodbearuserbyemail(SecurityContextHolder.getContext().getAuthentication().getName());

        return user.orElseThrow(()->new ResourceNotFoundException("USER_MISSING"));
    }

    public Authentication getAuth(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getRole(){
        return getAuth().getAuthorities().toArray()[0].toString();
    }

//    public Set<Object> getAllowedUser(){
//        if (getRole().equals("ROLE_ADMIN"))
//            return userDaoJpa.geAllUsers();
//        return null;
//    }

}
