package com.boyang.landsense.log.filter;

import cn.hutool.jwt.JWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("landsenseToken");
        try {
            if (JWT.of(token).setKey("landsense".getBytes()).verify()) {
                String username = (String) JWT.of(token).getPayload("username");
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(401);
        } finally {
            chain.doFilter(request, response);
        }

    }
}
