package org.example.securitydemo.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter implements Filter {

  private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;

    String requestId = request.getHeader("Request-Id");
    logger.info("Successfully authenticated request with id %s".formatted(requestId));

    filterChain.doFilter(servletRequest, servletResponse);
  }
}
