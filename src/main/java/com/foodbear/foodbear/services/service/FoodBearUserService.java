package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.FoodBearUser;
import org.springframework.security.access.annotation.Secured;

import java.util.Set;

public interface FoodBearUserService {
    @Secured("ROLE_ADMIN")
    Set<Object> getAllUsers();

    FoodBearUser createUser(FoodBearUser foodBearUser);

    void deleteUser(Long id);

    FoodBearUser updateUser(Long id, FoodBearUser foodBearUser);

    FoodBearUser findUserById(Long id);

    FoodBearUser findUserByUsername(String username);

    FoodBearUser getCurrentTokenUser();
}
