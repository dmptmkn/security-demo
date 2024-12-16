package org.example.securitydemo.configuration;

import java.util.List;
import org.example.securitydemo.model.User;
import org.example.securitydemo.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

//  @Bean
//  public UserDetailsService userDetailsService() {
//    InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//
//    UserDetails userDetails = User.builder()
//        .username("John")
//        .password("1234")
//        .authorities("write")
//        .build();
//    userDetailsService.createUser(userDetails);
//
//    userDetails = User.builder()
//        .username("Ivan")
//        .password("1234")
//        .authorities("read")
//        .build();
//    userDetailsService.createUser(userDetails);
//
//    return userDetailsService;
//  }

  @Bean
  public UserDetailsService userDetailsService() {
    User user = new User("Ivan", "1234", "read");
    return new InMemoryUserDetailsService(List.of(user));
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

}
