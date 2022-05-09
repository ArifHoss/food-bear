package com.foodbear.foodbear.service;

import com.foodbear.foodbear.entities.FoodBearUser;
import com.foodbear.foodbear.entities.FoodItem;
import com.foodbear.foodbear.entities.Restaurant;
import com.foodbear.foodbear.exception.ResourceNotFoundException;
import com.foodbear.foodbear.repo.FoodItemDaoJpa;
import com.foodbear.foodbear.repo.RestaurantDaoJpa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Service("foodItemService")
public class FoodItemService {

    private final FoodItemDaoJpa foodItemDaoJpa;
    private final RestaurantDaoJpa restaurantDaoJpa;

    public List<FoodItem> getAllFoodItems() {
        return (List<FoodItem>) foodItemDaoJpa.findAll();
    }

    public FoodItem addFoodItem(FoodItem foodItem,Long id) {
        Restaurant foundRestaurant = restaurantDaoJpa.findById(id).get();
        foodItem.setRestaurant(foundRestaurant);
        foodItemDaoJpa.save(foodItem);
        return foodItem;
    }

    public void deleteFoodItem(Long id) {
        foodItemDaoJpa.deleteById(id);
    }

    public void updateFoodItem(Long id, FoodItem foodItem) {
        FoodItem foundFoodItem = findItemById(id);

        if(foodItem.getFoodItem()!=null){
            foundFoodItem.setFoodItem(foodItem.getFoodItem());
        }if(foodItem.getPrice()!=null){
            foundFoodItem.setPrice(foodItem.getPrice());
        }if(foodItem.getType()!=null){
            foundFoodItem.setType(foodItem.getType());
        }
        foodItemDaoJpa.save(foundFoodItem);
    }

    public FoodItem getItemById(Long itemId) {
        return findItemById(itemId);
    }

    private FoodItem findItemById(Long itemId) {
        return foodItemDaoJpa.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("INVALID_FOOD_ITEM_ID"));
    }
}
