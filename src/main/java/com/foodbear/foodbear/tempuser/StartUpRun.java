package com.foodbear.foodbear.tempuser;

import com.foodbear.foodbear.entities.pojos.AuthorityType;
import com.foodbear.foodbear.entities.pojos.FoodBearUser;
import com.foodbear.foodbear.repo.FoodBearUserDaoJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

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
                    .encryptedPassword(passwordEncoder.encode("hej123").getBytes(StandardCharsets.UTF_8))
                    .build();
            foodBearUserDaoJpa.save(user);

            log.debug("User {} created...", user.getFirstName());
        }

        if ( !foodBearUserDaoJpa.existsByEmail("karin@bear.se") ) {
            FoodBearUser user = FoodBearUser.builder()
                    .firstName("Karin")
                    .lastName("Ismael")
                    .email("karin@bear.se")
                    .authorityType(AuthorityType.MANAGER)
                    .encryptedPassword(passwordEncoder.encode("hej123").getBytes(StandardCharsets.UTF_8))
                    .build();
            foodBearUserDaoJpa.save(user);

            log.debug("User {} created...", user.getFirstName());
        }

        if ( !foodBearUserDaoJpa.existsByEmail("zoro@bear.se") ) {
            FoodBearUser user = FoodBearUser.builder()
                    .firstName("Mr. Zoro")
                    .lastName("Zoro")
                    .email("zoro@bear.se")
                    .authorityType(AuthorityType.DELIVERY)
                    .encryptedPassword(passwordEncoder.encode("hej123").getBytes(StandardCharsets.UTF_8))
                    .build();
            foodBearUserDaoJpa.save(user);

            log.debug("User {} created...", user.getFirstName());
        }

        if ( !foodBearUserDaoJpa.existsByEmail("arif@bear.se") ) {
            FoodBearUser user = FoodBearUser.builder()
                    .firstName("Mr. Arif")
                    .lastName("Hossain")
                    .email("arif@bear.se")
                    .authorityType(AuthorityType.CUSTOMER)
                    .encryptedPassword(passwordEncoder.encode("hej123").getBytes(StandardCharsets.UTF_8))
                    .build();
            foodBearUserDaoJpa.save(user);

            log.debug("User {} created...", user.getFirstName());
        }
    }
}
