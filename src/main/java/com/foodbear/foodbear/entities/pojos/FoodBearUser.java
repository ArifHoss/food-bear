package com.foodbear.foodbear.entities.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "foodbearuser")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AttributeOverride(name = "id", column = @Column(name = "userId"))
public class FoodBearUser extends SharedClass{

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;


    private AuthorityType authorityType;

    @OneToOne (cascade = CascadeType.MERGE, orphanRemoval = true)
    private UserAddress userAddress;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<FoodOrder> orders = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordRaw;

    @JsonIgnore
    private byte[] encryptedPassword;

}
