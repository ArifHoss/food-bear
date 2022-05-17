package com.foodbear.foodbear.entities.dto;

import com.foodbear.foodbear.entities.pojos.FoodBearUser;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class UserAdressDto {

    private Long id;

    private String adressLine;
    private Long zipcode;
    private String City;

    private FoodBearUser foodBearUser;
}
