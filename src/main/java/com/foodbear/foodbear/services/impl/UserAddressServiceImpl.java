package com.foodbear.foodbear.services.impl;

import com.foodbear.foodbear.entities.pojos.FoodBearUser;
import com.foodbear.foodbear.entities.pojos.UserAddress;
import com.foodbear.foodbear.exception.ResourceNotFoundException;
import com.foodbear.foodbear.repo.FoodBearUserDaoJpa;
import com.foodbear.foodbear.repo.UserAddressDaoJpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service("userAddressService")
public class UserAddressServiceImpl implements com.foodbear.foodbear.services.service.UserAddressService {

    private UserAddressDaoJpa userAddressDaoJpa;
    private FoodBearUserDaoJpa foodBearUserDaoJpa;


    @Override
    public List<UserAddress> getAllAddress() {
        return userAddressDaoJpa.findAll();
    }

    @Override
    public UserAddress getAddressById(Long id) {
        return findAddressById(id);
    }

    @Override
    public UserAddress createAddress(UserAddress userAddress, Long userId) {
        FoodBearUser user = foodBearUserDaoJpa.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("USER_NOT_FOUND")
        );
        userAddress.setFoodBearUser(user);
        return userAddressDaoJpa.save(userAddress);
    }

    @Override
    public UserAddress update(Long id, UserAddress userAddress) {

        String adressLine = userAddress.getAdressLine();
        Long zipcode = userAddress.getZipcode();
        String city = userAddress.getCity();

        UserAddress address = findAddressById(id);

        if (userAddress.getAdressLine() != null) {
            address.setAdressLine(adressLine);
        }
        if (userAddress.getZipcode() != null) {
            address.setZipcode(zipcode);
        }
        if (userAddress.getCity() != null) {
            address.setCity(city);
        }
        return userAddressDaoJpa.save(address);
    }

    @Override
    public String delete(Long id) {
        UserAddress address = findAddressById(id);
        userAddressDaoJpa.delete(address);
        return "USER_ADDRESS_HAS_BEEN_DELETED";
    }



    private UserAddress findAddressById(Long id) {
        return userAddressDaoJpa.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ADDRESS_NOT_FOUND"));
    }
}
