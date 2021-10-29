package com.zuk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    private static final String ADMIN_ENDPOINT = "/api/v1/admin/**";
    private static final String AUTH_ENDPOINT = "/api/v1/auth/**";
    private static final String VENDING_ENDPOINT = "/api/v1/vending/**";
    private static final String STATIC_ENDPOINT = "/static/**";
    private static final String USERS_ENDPOINT = "/api/v1/users/**";
    private static final String TOKEN_ENDPOINT = "/api/v1/token/**";
    private static final String ITEM_ENDPOINT = "/api/v1/item/**";
    private static final String INDEX_ENDPOINT = "/index/**";


    @Autowired
    public SecurityConfig() {

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();
//        http
//                .httpBasic().disable()
//                .cors().and()
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers(AUTH_ENDPOINT).permitAll()
//                .antMatchers(TOKEN_ENDPOINT).permitAll()
//                .antMatchers(STATIC_ENDPOINT).permitAll()
//                .antMatchers(INDEX_ENDPOINT).permitAll()
//                .antMatchers(ITEM_ENDPOINT).permitAll()
//                .antMatchers(VENDING_ENDPOINT).permitAll()
//                .antMatchers(USERS_ENDPOINT).hasRole("USER")
//                .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and().
                //.apply(new JwtConfigurer(jwtTokenProvider));
    }
}