package com.foodbear.foodbear.entities.dto;

import com.foodbear.foodbear.entities.pojos.FoodBearUser;
import com.foodbear.foodbear.entities.pojos.FoodItem;
import com.foodbear.foodbear.entities.pojos.Promotion;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter @Setter
public class FoodOrderDto {

    private Long id;
    private LocalDateTime localDateTime;
    private FoodBearUser customer;
    private Set<FoodItem> orderItems = new HashSet<>();
    private Promotion promotion;
}
