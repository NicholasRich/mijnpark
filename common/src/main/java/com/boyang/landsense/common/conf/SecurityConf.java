//package com.boyang.mujipark.common.conf;
//
//import com.boyang.mujipark.common.service.impl.UserServImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConf extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserServImpl userServ;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userServ).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//
//}
