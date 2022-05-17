package com.foodbear.foodbear.repo;

import com.foodbear.foodbear.entities.pojos.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("restaurantDaoJpa")
public interface RestaurantDaoJpa extends CrudRepository<Restaurant, Long> {

}
