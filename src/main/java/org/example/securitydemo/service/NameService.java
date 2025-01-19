package org.example.securitydemo.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    @PreAuthorize("hasAuthority('read')")
    public String getRealName() {
      return "Ivan";
    }
}
