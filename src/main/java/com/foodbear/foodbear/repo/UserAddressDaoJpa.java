package com.foodbear.foodbear.repo;

import com.foodbear.foodbear.entities.pojos.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userAddressDaoJpa")
public interface UserAddressDaoJpa extends JpaRepository<UserAddress, Long> {
}
