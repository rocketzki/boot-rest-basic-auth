package com.rocketzki.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class WebSecuritySettings extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication
                .inMemoryAuthentication()
                .withUser("johny")
                .password(passEncrypt().encode("ThePass12")).roles("USER")
                .and()
                .withUser("mary")
                .password(passEncrypt().encode("ThePass12")).roles("ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().and().authorizeRequests()
                .antMatchers("/rest/laptop/**", "/rest/laptops").permitAll()
                .antMatchers("/rest/admin/**", "/rest/laptop/add").hasRole("ADMIN")
                .and().csrf().disable().headers().frameOptions().disable().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().logout();
    }

    @Bean
    public PasswordEncoder passEncrypt() {
        return new BCryptPasswordEncoder();
    }


}


