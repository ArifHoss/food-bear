package com.foodbear.foodbear.service;

import com.foodbear.foodbear.entities.FoodBearUser;
import com.foodbear.foodbear.exception.ConflictException;
import com.foodbear.foodbear.exception.ResourceNotFoundException;
import com.foodbear.foodbear.repo.FoodBearUserDaoJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service("foodBearUserService")
public class FoodBearUserService {

    private final FoodBearUserDaoJpa foodBearUserDaoJpa;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<FoodBearUser> getAllUsers() {
        return (List<FoodBearUser>) foodBearUserDaoJpa.findAll();
    }


    public FoodBearUser createUser(FoodBearUser foodBearUser) {


        checkExistingEmail(foodBearUser);

        foodBearUser.setPassword(passwordEncoder.encode(foodBearUser.getPassword()));

         foodBearUserDaoJpa.save(foodBearUser);
         return foodBearUser;
    }


    public void deleteUser(Long id) {
        FoodBearUser user = findUser(id);
        foodBearUserDaoJpa.delete(user);
    }

    public void updateUser(Long id, FoodBearUser foodBearUser) {
        FoodBearUser foundUser = findUser(id);

        if (foodBearUser.getFirstName() != null) {
            foundUser.setFirstName(foodBearUser.getFirstName());
        }
        if (foodBearUser.getLastName() != null) {
            foundUser.setLastName(foodBearUser.getLastName());
        }
        if (foodBearUser.getEmail() != null) {
            foundUser.setEmail(foodBearUser.getEmail());
        }
        if (foodBearUser.getPassword() != null) {
            foundUser.setPassword(foodBearUser.getPassword());
        }
        if (foodBearUser.getAuthorizationType() != null) {
            foundUser.setAuthorizationType(foodBearUser.getAuthorizationType());
        }

        foodBearUserDaoJpa.save(foundUser);
    }

    public FoodBearUser findUserById(Long id) {
        return findUser(id);
    }

    private FoodBearUser findUser(Long id) {
        return foodBearUserDaoJpa.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("USER_NOT_FOUND"));
    }

    private void checkExistingEmail(FoodBearUser foodBearUser) {
        String email = foodBearUser.getEmail();
        List<String> existing = foodBearUserDaoJpa.existingEmail();

        if (existing.contains(email)) {
            throw new ConflictException("EMAIL_ALREADY_EXIST");
        }
    }
}
