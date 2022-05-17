package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.dto.UserAdressDto;
import com.foodbear.foodbear.entities.pojos.UserAddress;
import com.foodbear.foodbear.services.service.UserAddressService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/address")
public class UserAddressController {

    private UserAddressService userAddressService;
    ModelMapper modelMapper;

    @GetMapping
    public List<UserAdressDto> getAllAddress(){
        return userAddressService.getAllAddress().stream()
                .map(adress -> modelMapper.map(adress, UserAdressDto.class)).toList();
    }
    @GetMapping("/{id}")
    public UserAdressDto getAddressById(@PathVariable Long id){
        UserAddress foundAdress = userAddressService.getAddressById(id);
        return modelMapper.map(foundAdress, UserAdressDto.class);
    }

    @PostMapping("user/{userId}")
    public UserAdressDto create(@RequestBody UserAddress userAddress,
                              @PathVariable("userId") Long userId){
        UserAddress newAdress = userAddressService.createAddress(userAddress, userId);
        return modelMapper.map(newAdress, UserAdressDto.class);
    }

    @PatchMapping("/{id}")
    public UserAdressDto update(@PathVariable Long id, @RequestBody UserAddress userAddress){
        UserAddress updatedAdress = userAddressService.update(id, userAddress);
        return modelMapper.map(updatedAdress, UserAdressDto.class);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return userAddressService.delete(id);
    }
}
