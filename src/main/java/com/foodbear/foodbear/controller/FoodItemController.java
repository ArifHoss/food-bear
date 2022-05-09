package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.FoodItem;
import com.foodbear.foodbear.entities.Restaurant;
import com.foodbear.foodbear.service.FoodItemService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/fooditem")
public class FoodItemController {

    private FoodItemService foodItemService;

    @GetMapping
    public List<FoodItem> getAllFoodItems(){
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("{itemId}")
    public FoodItem getItemById(@PathVariable("itemId") Long itemId){
        return foodItemService.getItemById(itemId);
    }

    @PostMapping("/restaurant/{restaurantId}")
    public FoodItem addFoodItem(@RequestBody FoodItem foodItem,@PathVariable("restaurantId") Long restaurantId){
        return foodItemService.addFoodItem(foodItem, restaurantId);
    }

    @DeleteMapping("/{id}")
    public void deleteFoodItem(@PathVariable ("id") Long id){
        foodItemService.deleteFoodItem(id);
    }

    @PatchMapping("/{id}")
    public void updateFoodItem(@PathVariable("id") Long id, @RequestBody FoodItem foodItem){
        foodItemService.updateFoodItem(id, foodItem);
    }

}
