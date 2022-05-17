package com.foodbear.foodbear.entities.dto;

import com.foodbear.foodbear.entities.pojos.FoodItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter @Setter
public class RestaurantDto {

    private Long id;
    private String name;

    private Set<FoodItem> foodItems = new HashSet<>();

}
