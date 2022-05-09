package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.UserAddress;
import com.foodbear.foodbear.services.service.UserAddressService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/address")
public class UserAddressController {

    private UserAddressService userAddressService;

    @GetMapping
    public List<UserAddress> getAllAddress(){
        return userAddressService.getAllAddress();
    }
    @GetMapping("/{id}")
    public UserAddress getAddressById(@PathVariable Long id){
        return userAddressService.getAddressById(id);
    }

    @PostMapping("user/{userId}")
    public UserAddress create(@RequestBody UserAddress userAddress,
                              @PathVariable("userId") Long userId){
        return userAddressService.createAddress(userAddress, userId);
    }

    @PatchMapping("/{id}")
    public UserAddress update(@PathVariable Long id, @RequestBody UserAddress userAddress){
        return userAddressService.update(id, userAddress);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return userAddressService.delete(id);
    }
}
