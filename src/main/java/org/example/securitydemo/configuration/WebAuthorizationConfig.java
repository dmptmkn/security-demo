package org.example.securitydemo.configuration;

import org.example.securitydemo.filter.AuthenticationLoggingFilter;
import org.example.securitydemo.filter.RequestValidationFilter;
import org.example.securitydemo.filter.StaticKeyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebAuthorizationConfig {

  private final StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;

  public WebAuthorizationConfig(StaticKeyAuthenticationFilter staticKeyAuthenticationFilter) {
    this.staticKeyAuthenticationFilter = staticKeyAuthenticationFilter;
  }

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
        .addFilterAt(staticKeyAuthenticationFilter, BasicAuthenticationFilter.class)
        .addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
        .authorizeHttpRequests(c -> c.anyRequest().permitAll());

    return http.build();
  }

}
