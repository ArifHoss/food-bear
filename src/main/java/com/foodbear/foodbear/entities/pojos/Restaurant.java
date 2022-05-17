package com.foodbear.foodbear.entities.pojos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "restaurantId"))
public class Restaurant extends SharedClass{

    private String name;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<FoodItem> foodItems = new HashSet<>();

}
