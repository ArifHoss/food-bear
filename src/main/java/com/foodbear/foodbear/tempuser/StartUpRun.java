package com.foodbear.foodbear.tempuser;

import com.foodbear.foodbear.entities.AuthorityType;
import com.foodbear.foodbear.entities.FoodBearUser;
import com.foodbear.foodbear.repo.FoodBearUserDaoJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StartUpRun implements CommandLineRunner {

    private final FoodBearUserDaoJpa foodBearUserDaoJpa;

    @Override
    public void run(String... args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if ( !foodBearUserDaoJpa.existsByEmail("food@bear.se") ) {
            FoodBearUser user = FoodBearUser.builder()
                    .firstName("Mr. Food")
                    .lastName("Bear")
                    .email("food@bear.se")
                    .authorityType(AuthorityType.ADMIN)
                    .password(passwordEncoder.encode("hej123"))
                    .build();
            foodBearUserDaoJpa.save(user);

            log.debug("User {} created...", user.getFirstName());
        }
    }
}
