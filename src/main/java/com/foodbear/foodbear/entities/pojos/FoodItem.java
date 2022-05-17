package com.foodbear.foodbear.entities.pojos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fooditem")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "fooditemId"))
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String foodItem;
    private Long price;
    private String type;

    @ManyToOne (cascade = CascadeType.MERGE)
    private Restaurant restaurant;


}
