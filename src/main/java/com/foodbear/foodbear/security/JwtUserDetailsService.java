package com.foodbear.foodbear.security;

import com.foodbear.foodbear.entities.FoodBearUser;
import com.foodbear.foodbear.repo.FoodBearUserDaoJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final FoodBearUserDaoJpa foodBearUserDaoJpa;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("In JwtUserDetailsService.loadUserByUsername()......");
        log.debug("Accessing db to retrieve user {}......", username);
        Optional<FoodBearUser> userOpt = foodBearUserDaoJpa.findfoodbearuserbyemail(username);
        if (userOpt.isPresent()) {
            FoodBearUser foodBearUser = userOpt.get();
            log.trace("User found");
            Charset charset = Charset.forName("UTF-8");
            byte[] passEncrypted = foodBearUser.getEncryptedPassword();
            String passString = new String(passEncrypted, charset);
            ArrayList<GrantedAuthority> authority = new ArrayList<>();
            log.debug("Building authorities......");

            authority.add(new SimpleGrantedAuthority("ROLE_" + foodBearUser.getAuthorityType().toString()));

            log.debug("Returning response......");
            return new User(foodBearUser.getEmail(), passString, authority);
        } else {
            throw new UsernameNotFoundException("USER_NOT_FOUND");
        }
    }
}
