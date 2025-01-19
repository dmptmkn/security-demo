package org.example.securitydemo.configuration;

import java.util.List;
import org.example.securitydemo.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

  //Basic UserDetailsService implementation
  @Bean
  public UserDetailsService userDetailsService() {
    var manager = new InMemoryUserDetailsManager();

    var user1 = User.withUsername("john")
        .password("1234")
        .authorities("read")
        .build();

    var user2 = User.withUsername("jane")
        .password("1234")
        .authorities("write")
        .build();

    manager.createUser(user1);
    manager.createUser(user2);

    return manager;
  }

  //Custom UserDetailsService implementation
//  @Bean
//  public UserDetailsService userDetailsService() {
//    User user = new User("Ivan", "1234", "read");
//    return new InMemoryUserDetailsService(List.of(user));
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
//    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
}
