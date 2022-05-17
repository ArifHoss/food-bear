package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.pojos.FoodBearUser;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface FoodBearUserService {
    @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
    List<FoodBearUser> getAllUsers();

    @Secured("ROLE_ADMIN")
    FoodBearUser createUser(FoodBearUser foodBearUser);

    @Secured("ROLE_ADMIN")
    void deleteUser(Long id);

    @Secured("ROLE_ADMIN")
    FoodBearUser updateUser(Long id, FoodBearUser foodBearUser);

    FoodBearUser findUserById(Long id);

    FoodBearUser findUserByUsername(String username);

    FoodBearUser getCurrentTokenUser();
}
