package org.example.securitydemo.controller;

import org.example.securitydemo.service.NameService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GreetingController {

  private final NameService nameService;

  public GreetingController(NameService nameService) {
    this.nameService = nameService;
  }

  @GetMapping
  public String greetGet() {
    SecurityContext context = SecurityContextHolder.getContext();
    return "Hello, %s!".formatted(context.getAuthentication().getName());
  }

  @PostMapping
  public String greetPost() {
    SecurityContext context = SecurityContextHolder.getContext();
    return "Hello, %s! Your CSRF token is correct".formatted(context.getAuthentication().getName());
  }

  @GetMapping("/real")
  public String secureGreetRead() {
    return "Hello, %s".formatted(nameService.getRealName());
  }

  @GetMapping("/fake")
  public String secureGreetWrite() {
    return "Hello, %s".formatted(nameService.getFakeName());
  }
}
