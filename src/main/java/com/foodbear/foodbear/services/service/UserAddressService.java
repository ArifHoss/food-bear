package com.foodbear.foodbear.services.service;

import com.foodbear.foodbear.entities.UserAddress;

import java.util.List;

public interface UserAddressService {
    List<UserAddress> getAllAddress();

    UserAddress getAddressById(Long id);

    UserAddress createAddress(UserAddress userAddress, Long userId);

    UserAddress update(Long id, UserAddress userAddress);

    String delete(Long id);
}
