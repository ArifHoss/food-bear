package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.FoodBearUser;
import com.foodbear.foodbear.entities.FoodItem;
import com.foodbear.foodbear.services.service.FoodBearUserService;
import com.foodbear.foodbear.services.service.FoodItemService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Data
@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/fooditem")
public class FoodItemController {

    private FoodItemService foodItemService;
    private FoodBearUserService foodBearUserService;

    @GetMapping("/foodbear")
    public String showFoodItems(Model model){
        List<FoodItem> list = foodItemService.getAllFoodItems();
        model.addAttribute("items", list);
        return "index";
    }

    @GetMapping
    public List<FoodItem> getAllFoodItems(){
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("{itemId}")
    public FoodItem getItemById(@PathVariable("itemId") Long itemId){
        return foodItemService.getItemById(itemId);
    }

    @PostMapping("/restaurant/{restaurantId}")
    public FoodItem createFoodItemWithRestaurant(@RequestBody FoodItem foodItem, @PathVariable("restaurantId") Long restaurantId){
        return foodItemService.createFoodItemWithRestaurant(foodItem, restaurantId);
    }

    @DeleteMapping("/{id}")
    public String deleteFoodItem(@PathVariable ("id") Long id){
        foodItemService.deleteFoodItem(id);

        return "ITEM HAS BEEN DELETED";
    }

    @PatchMapping("/{id}")
    public FoodItem updateFoodItem(@PathVariable("id") Long id, @RequestBody FoodItem foodItem){
        return foodItemService.updateFoodItem(id, foodItem);
    }

}
