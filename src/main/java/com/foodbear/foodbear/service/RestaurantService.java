package com.foodbear.foodbear.service;

import com.foodbear.foodbear.entities.Restaurant;
import com.foodbear.foodbear.exception.ResourceNotFoundException;
import com.foodbear.foodbear.repo.RestaurantDaoJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service("restaurantService")
public class RestaurantService {

    private RestaurantDaoJpa restaurantDaoJpa;

    public List<Restaurant> getAllRestaurant() {
        return (List<Restaurant>) restaurantDaoJpa.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return findRestaurantById(id);
    }


    public Restaurant create(Restaurant restaurant){
        return restaurantDaoJpa.save(restaurant);
    }

    public Restaurant update(Long id, Restaurant restaurant){

        Restaurant findRestaurantToUpdate = findRestaurantById(id);
        String newName = restaurant.getName();

        if (newName !=null) {
            findRestaurantToUpdate.setName(newName);
        }

        return restaurantDaoJpa.save(findRestaurantToUpdate);

    }

    public String delete(Long id){
        Restaurant restaurant= findRestaurantById(id);
        restaurantDaoJpa.delete(restaurant);
        return "RESTAURANT_DELETED";
    }



    private Restaurant findRestaurantById(Long id) {
        return restaurantDaoJpa.findById(id).orElseThrow(() -> new ResourceNotFoundException("INVALID_RESTAURANT_ID"));
    }
}
