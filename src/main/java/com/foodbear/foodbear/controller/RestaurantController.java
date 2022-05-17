package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.dto.RestaurantDto;
import com.foodbear.foodbear.entities.pojos.Restaurant;
import com.foodbear.foodbear.services.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;
    private ModelMapper modelMapper;

    @GetMapping
    public List<RestaurantDto> getAllRestaurant(){
        return restaurantService.getAllRestaurant().stream()
                .map(restaurant -> modelMapper.map(restaurant, RestaurantDto.class)).toList();
    }

    @GetMapping("/{id}")
    public RestaurantDto getRestaurantById(@PathVariable Long id){
        Restaurant foundRestaurant = restaurantService.getRestaurantById(id);
        return modelMapper.map(foundRestaurant, RestaurantDto.class);
    }

    @PostMapping
    public RestaurantDto create(@RequestBody Restaurant restaurant){
        Restaurant newRestaurant = restaurantService.create(restaurant);
        return modelMapper.map(newRestaurant, RestaurantDto.class);
    }


    @PatchMapping("/{id}")
    public RestaurantDto update(@PathVariable Long id,@RequestBody Restaurant restaurant){
        Restaurant updatedRestaurant = restaurantService.update(id, restaurant);
        return modelMapper.map(updatedRestaurant, RestaurantDto.class);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return restaurantService.delete(id);
    }
}
