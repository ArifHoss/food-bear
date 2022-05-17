package com.foodbear.foodbear.repo;

import com.foodbear.foodbear.entities.pojos.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("orderDaoJpa")
public interface FoodOrderDaoJpa extends JpaRepository<FoodOrder, Long> {

}
