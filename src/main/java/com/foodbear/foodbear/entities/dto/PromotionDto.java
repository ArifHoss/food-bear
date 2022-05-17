package com.foodbear.foodbear.entities.dto;

import com.foodbear.foodbear.entities.pojos.FoodOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter @Setter
public class PromotionDto {

    private Long id;
    private Long discount;
    private String promotionName;

    private Set<FoodOrder> orders = new HashSet<>();

}
