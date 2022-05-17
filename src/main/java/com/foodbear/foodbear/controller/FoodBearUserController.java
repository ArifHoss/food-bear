package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.dto.FoodBearUserDto;
import com.foodbear.foodbear.entities.pojos.FoodBearUser;
import com.foodbear.foodbear.services.impl.FoodBearUserServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class FoodBearUserController {

    private final FoodBearUserServiceImpl foodBearUserServiceImpl;
    private ModelMapper modelMapper;

    @GetMapping
    public List<FoodBearUserDto> getAllUsers(){

        return foodBearUserServiceImpl.getAllUsers().stream()
                .map(user -> modelMapper.map(user, FoodBearUserDto.class)).toList();
    }

    @GetMapping("{id}")
    public FoodBearUserDto findUserById(@PathVariable Long id){
        FoodBearUser foundUser = foodBearUserServiceImpl.findUserById(id);
        return modelMapper.map(foundUser, FoodBearUserDto.class);
    }

    @PostMapping
    public  FoodBearUserDto createUser(@RequestBody FoodBearUser foodBearUser){
        FoodBearUser newUser = foodBearUserServiceImpl.createUser(foodBearUser);
        return modelMapper.map(newUser, FoodBearUserDto.class);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        foodBearUserServiceImpl.deleteUser(id);
        return "USER HAS BEEN DELETED";
    }
    @PatchMapping("/{id}")
    public FoodBearUserDto updateUser(@PathVariable("id") Long id, @RequestBody FoodBearUser foodBearUser){
        FoodBearUser foundUser = foodBearUserServiceImpl.updateUser(id, foodBearUser);
        return modelMapper.map(foundUser, FoodBearUserDto.class);
    }
}
