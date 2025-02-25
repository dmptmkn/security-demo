package org.example.securitydemo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthenticationLoggingFilter extends OncePerRequestFilter {

  private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String requestId = request.getHeader("Request-Id");
    logger.info("Successfully authenticated request with id %s".formatted(requestId));

    filterChain.doFilter(request, response);
  }
}
