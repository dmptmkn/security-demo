package org.example.securitydemo.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    @PreAuthorize("hasAuthority('read')")
    public String getRealName() {
      return "Ivan";
    }

    @PostAuthorize("hasAuthority('write')")
    public String getFakeName() {
      return "Ivan the Terrible";
    }
}
