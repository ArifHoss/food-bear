package com.foodbear.foodbear.controller;

import com.foodbear.foodbear.entities.FoodBearUser;
import com.foodbear.foodbear.security.JwToken;
import com.foodbear.foodbear.security.JwtBody;
import com.foodbear.foodbear.security.JwtGenerator;
import com.foodbear.foodbear.services.service.FoodBearUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class JwtController {

    private final JwtGenerator jwtGenerator;
    private final FoodBearUserService foodBearUserService;

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtBody jwtBody ) throws Exception{


        FoodBearUser foundUser = foodBearUserService.findUserByUsername(jwtBody.getUsername());

        String username = foundUser.getEmail();

        String token = jwtGenerator.generateToken(username);

        return ResponseEntity.ok(new JwToken(token));

    }

}
