package com.foodbear.foodbear.entities.dto;

import com.foodbear.foodbear.entities.pojos.AuthorityType;
import com.foodbear.foodbear.entities.pojos.UserAddress;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class FoodBearUserDto {

    private Long id;
    private String firstName;
    private String lastName;

    private String email;

    private AuthorityType authorityType;

    private UserAddress userAddress;

}
