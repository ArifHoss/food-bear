package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.Restaurant;
import com.foodbear.foodbear.services.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id){
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping
    public Restaurant create(@RequestBody Restaurant restaurant){
        return restaurantService.create(restaurant);
    }


    @PatchMapping("/{id}")
    public Restaurant update(@PathVariable Long id,@RequestBody Restaurant restaurant){
        return restaurantService.update(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return restaurantService.delete(id);
    }
}
