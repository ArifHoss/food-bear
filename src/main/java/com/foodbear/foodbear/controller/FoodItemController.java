package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.dto.FoodItemDto;
import com.foodbear.foodbear.entities.pojos.FoodItem;
import com.foodbear.foodbear.services.service.FoodBearUserService;
import com.foodbear.foodbear.services.service.FoodItemService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/fooditem")
public class FoodItemController {

    private FoodItemService foodItemService;
    private FoodBearUserService foodBearUserService;
    private ModelMapper modelMapper;


    @GetMapping
    public List<FoodItemDto> getAllFoodItems() {

        return foodItemService.getAllFoodItems().stream()
                .map(item -> modelMapper.map(item, FoodItemDto.class)).toList();
    }

    @GetMapping("{itemId}")
    public FoodItemDto getItemById(@PathVariable("itemId") Long itemId) {

        FoodItem foundItem = foodItemService.getItemById(itemId);

        return modelMapper.map(foundItem, FoodItemDto.class);
    }

    @PostMapping("/restaurant/{restaurantId}")
    public FoodItemDto createFoodItemWithRestaurant(@RequestBody FoodItem foodItem,
                                                    @PathVariable("restaurantId") Long restaurantId) {

        FoodItem newFoodItem = foodItemService.createFoodItemWithRestaurant(foodItem, restaurantId);

        return modelMapper.map(newFoodItem, FoodItemDto.class);
    }

    @DeleteMapping("/{id}")
    public String deleteFoodItem(@PathVariable("id") Long id) {
        foodItemService.deleteFoodItem(id);

        return "ITEM HAS BEEN DELETED";
    }

    @PatchMapping("/{id}")
    public FoodItemDto updateFoodItem(@PathVariable("id") Long id,
                                      @RequestBody FoodItem foodItem) {

        FoodItem foundItem = foodItemService.updateFoodItem(id, foodItem);

        return modelMapper.map(foundItem, FoodItemDto.class);
    }

}
