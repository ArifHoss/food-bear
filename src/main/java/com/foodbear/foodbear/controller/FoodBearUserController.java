package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.FoodBearUser;
import com.foodbear.foodbear.services.impl.FoodBearUserServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Data
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class FoodBearUserController {

    private final FoodBearUserServiceImpl foodBearUserServiceImpl;

    @GetMapping
    public Set<Object> getAllUsers(){
        return foodBearUserServiceImpl.getAllUsers();
    }

    @GetMapping("{id}")
    public FoodBearUser findUserById(@PathVariable Long id){
        return foodBearUserServiceImpl.findUserById(id);
    }

    @PostMapping
    public  FoodBearUser createUser(@RequestBody FoodBearUser foodBearUser){
        return foodBearUserServiceImpl.createUser(foodBearUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        foodBearUserServiceImpl.deleteUser(id);
        return "USER HAS BEEN DELETED";
    }
    @PatchMapping("/{id}")
    public FoodBearUser updateUser(@PathVariable("id") Long id, @RequestBody FoodBearUser foodBearUser){
        return foodBearUserServiceImpl.updateUser(id, foodBearUser);
    }
}
