package com.foodbear.foodbear.entities.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foodbearorder")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "orderId"))
public class FoodOrder extends SharedClass{

    private Long totalPrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    private FoodBearUser customer;

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<FoodItem> orderItems=new HashSet<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    private Promotion promotion;

   @PrePersist
    public void getCurrentDate(){
       setLocalDateTime(LocalDateTime.now());
   }
}
