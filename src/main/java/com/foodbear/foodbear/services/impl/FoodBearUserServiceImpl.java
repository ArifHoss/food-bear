package com.foodbear.foodbear.services.impl;

import com.foodbear.foodbear.entities.FoodBearUser;
import com.foodbear.foodbear.exception.ConflictException;
import com.foodbear.foodbear.exception.ResourceNotFoundException;
import com.foodbear.foodbear.repo.FoodBearUserDaoJpa;
import com.foodbear.foodbear.services.service.FoodBearUserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service("foodBearUserService")
public class FoodBearUserServiceImpl implements FoodBearUserService {

    private final FoodBearUserDaoJpa foodBearUserDaoJpa;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<FoodBearUser> getAllUsers() {
        return (List<FoodBearUser>) foodBearUserDaoJpa.findAll();
    }


    @Override
    public FoodBearUser createUser(FoodBearUser foodBearUser) {


        checkExistingEmail(foodBearUser);

        foodBearUser.setPassword(passwordEncoder.encode(foodBearUser.getPassword()));

         foodBearUserDaoJpa.save(foodBearUser);
         return foodBearUser;
    }


    @Override
    public void deleteUser(Long id) {
        FoodBearUser user = findUser(id);
        foodBearUserDaoJpa.delete(user);
    }

    @Override
    public FoodBearUser updateUser(Long id, FoodBearUser foodBearUser) {
        FoodBearUser foundUser = findUser(id);

        if (foodBearUser.getFirstName() != null) {
            foundUser.setFirstName(foodBearUser.getFirstName());
        }
        if (foodBearUser.getLastName() != null) {
            foundUser.setLastName(foodBearUser.getLastName());
        }
        if (foodBearUser.getEmail() != null) {
            checkExistingEmail(foodBearUser);
            foundUser.setEmail(foodBearUser.getEmail());
        }
        if (foodBearUser.getPassword() != null) {
            foundUser.setPassword(foodBearUser.getPassword());
        }
        if (foodBearUser.getAuthorityType() != null) {
            foundUser.setAuthorityType(foodBearUser.getAuthorityType());
        }

        return foodBearUserDaoJpa.save(foundUser);
    }

    @Override
    public FoodBearUser findUserById(Long id) {
        return findUser(id);
    }

    @Override
    public FoodBearUser findUserByUsername(String username) {
        return foodBearUserDaoJpa.findByEmail(username);
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
