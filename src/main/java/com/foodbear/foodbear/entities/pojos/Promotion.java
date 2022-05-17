package com.foodbear.foodbear.entities.pojos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "promotionId"))
public class Promotion extends SharedClass{

    private Long discount;
    private String promotionName;

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<FoodOrder> orders = new HashSet<>();
}
