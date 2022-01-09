package com.callsign.customer.support.client;

import com.callsign.customer.support.rto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Shadab Khan
 * @since 09/01/2022
 */
@FeignClient(name = "user-management", path = "/api/users/", url = "${user.management.url}", primary = false)
public interface UserClient extends UserDetailsService {

    @GetMapping(value = "/{username}", produces = "application/json")
    @Override
    User loadUserByUsername(@PathVariable(value = "username") String username);
}
