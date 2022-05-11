package com.foodbear.foodbear.repo;

import com.foodbear.foodbear.entities.FoodBearUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("foodBearUserDaoJpa")
public interface FoodBearUserDaoJpa extends CrudRepository<FoodBearUser, Long> {
    FoodBearUser findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("SELECT f.email FROM FoodBearUser f")
    List<String> existingEmail();

    @Query("select u from FoodBearUser u where u.email=?1")
    Optional<FoodBearUser> findfoodbearuserbyemail(String email);
}
