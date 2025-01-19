package org.example.securitydemo.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import org.springframework.security.web.csrf.CsrfToken;

public class CsrfTokenLoggingFilter implements Filter {

  private Logger logger = Logger.getLogger(CsrfTokenLoggingFilter.class.getName());

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    CsrfToken csrf = (CsrfToken) servletRequest.getAttribute("_csrf");
    logger.info("CSRF-token: %s".formatted(csrf.getToken()));

    filterChain.doFilter(servletRequest, servletResponse);
  }
}
