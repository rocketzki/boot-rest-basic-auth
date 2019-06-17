package com.rocketzki.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;


@Configuration
@EnableWebSecurity
public class WebSecuritySettings extends WebSecurityConfigurerAdapter {

    private RestAuthEntryPoint restAuthEntryPoint;
    private SuccessAuthHandler successAuthHandler;

    @Autowired
    WebSecuritySettings(RestAuthEntryPoint restAuthEntryPoint, SuccessAuthHandler successAuthHandler) {
        this.restAuthEntryPoint = restAuthEntryPoint;
        this.successAuthHandler = successAuthHandler;

    }

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
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/rest/laptop/**", "/rest/laptops**").authenticated()
//                .hasAnyRole("USER","ADMIN")
                .antMatchers("/rest/admin/**", "/rest/laptop/add").permitAll()
//                .hasRole("ADMIN")
                .and()
                .formLogin()
                .successHandler(successAuthHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout();
    }

    @Bean
    public PasswordEncoder passEncrypt() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }


}


