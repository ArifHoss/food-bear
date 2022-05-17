package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.pojos.Restaurant;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface RestaurantService {
    @Secured("ROLE_ADMIN")
    List<Restaurant> getAllRestaurant();

    Restaurant getRestaurantById(Long id);

    @Secured("ROLE_ADMIN")
    Restaurant create(Restaurant restaurant);

    @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    Restaurant update(Long id, Restaurant restaurant);

    @Secured("ROLE_ADMIN")
    String delete(Long id);
}
