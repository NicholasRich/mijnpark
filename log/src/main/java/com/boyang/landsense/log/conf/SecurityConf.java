package com.boyang.landsense.log.conf;

import cn.hutool.jwt.JWT;
import com.boyang.landsense.log.filter.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {
    @Autowired
    private JWTAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;
    @Autowired
    private JWTAuthenticationFailureHandler jwtAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated().and()
                .formLogin().successHandler(jwtAuthenticationSuccessHandler).permitAll()
//                .failureHandler(jwtAuthenticationFailureHandler).permitAll()
                .and().addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .logout()
                .permitAll()
        ;
    }


    public static void main(String[] args) {
        System.out.println(JWT.of("das").getPayload("fsa"));
    }


}
//loginPage("http://localhost:63342/mijnpark/page/login.html").loginProcessingUrl("/login").