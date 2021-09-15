package com.boyang.landsense.log.conf;

import com.boyang.landsense.log.filter.ICorsFilter;
import com.boyang.landsense.log.filter.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {
    @Autowired
    private JWTAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;
    @Autowired
    private JWTAuthenticationFailureHandler jwtAuthenticationFailureHandler;
    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;
    @Autowired
    private ICorsFilter iCorsFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated().and()
                .formLogin()
                .successHandler(jwtAuthenticationSuccessHandler)
                .failureHandler(jwtAuthenticationFailureHandler).and()
                .addFilterBefore(iCorsFilter, CorsFilter.class)
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .permitAll()
        ;
    }
}