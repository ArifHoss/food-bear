package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.FoodBearUser;

import java.util.List;

public interface FoodBearUserService {
    List<FoodBearUser> getAllUsers();

    FoodBearUser createUser(FoodBearUser foodBearUser);

    void deleteUser(Long id);

    FoodBearUser updateUser(Long id, FoodBearUser foodBearUser);

    FoodBearUser findUserById(Long id);

    FoodBearUser findUserByUsername(String username);
}
