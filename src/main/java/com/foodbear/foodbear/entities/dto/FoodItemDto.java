package com.foodbear.foodbear.entities.dto;

import com.foodbear.foodbear.entities.pojos.Restaurant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class FoodItemDto {

    private Long id;
    private String foodItem;
    private Long price;
    private String type;

    private Restaurant restaurant;
}
