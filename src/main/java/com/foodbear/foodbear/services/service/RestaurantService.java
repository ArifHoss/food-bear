package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurant();

    Restaurant getRestaurantById(Long id);

    Restaurant create(Restaurant restaurant);

    Restaurant update(Long id, Restaurant restaurant);

    String delete(Long id);
}
