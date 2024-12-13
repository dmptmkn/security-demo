package org.example.securitydemo.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GreetingController {

  @GetMapping
  public String greet() {
    SecurityContext context = SecurityContextHolder.getContext();

    return "Hello, %s!".formatted(context.getAuthentication().getName());
  }
}
