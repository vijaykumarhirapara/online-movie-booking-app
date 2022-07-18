package com.vijay.booking.controller.moviebookingapi.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CorsFilter extends OncePerRequestFilter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CorsFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
        response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
        
        //validate header Authorization bearer token if not valid then response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        LOGGER.debug("In  CorsFilter.doFilterInternal() CORS Filter request URL ===> " + request.getRequestURI());
        LOGGER.trace("In  CorsFilter.doFilterInternal() CORS Filter request headers ===> " + request.getHeaderNames());
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else { 
            filterChain.doFilter(request, response);
        }
    }
}