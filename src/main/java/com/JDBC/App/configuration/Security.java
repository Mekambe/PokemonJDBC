package com.JDBC.App.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity http) throws Exception {


        http.csrf().disable(); //turning it off for tests
        http.authorizeRequests().antMatchers("api/**").authenticated();
        http.headers().frameOptions().disable(); //disabling the header for testing
        http.httpBasic();

    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService(){ //do not use it on production, only for testing
        //...
        User.UserBuilder user=User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager menager = new InMemoryUserDetailsManager();
        menager.createUser(user.username("asd").password("asd").roles("USER").build());

        return menager;

    }


}
