package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.dto.FoodItemDto;
import com.foodbear.foodbear.entities.pojos.FoodItem;

import java.util.List;

public interface FoodItemService {
    List<FoodItem> getAllFoodItems();

    FoodItem createFoodItemWithRestaurant(FoodItem foodItem, Long id);

    void deleteFoodItem(Long id);

    FoodItem updateFoodItem(Long id, FoodItem foodItem);

    FoodItem getItemById(Long itemId);
}
