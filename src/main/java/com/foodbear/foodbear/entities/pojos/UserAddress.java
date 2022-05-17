package com.foodbear.foodbear.entities.pojos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "useraddress")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "useraddressId"))
public class UserAddress extends SharedClass{

    private String adressLine;
    private Long zipcode;
    private String City;

    @OneToOne(cascade = CascadeType.MERGE)
    private FoodBearUser foodBearUser;


}
