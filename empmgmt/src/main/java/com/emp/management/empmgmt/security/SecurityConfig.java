package com.emp.management.empmgmt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request)->
                request.requestMatchers(HttpMethod.GET,"/api/fetch").hasRole("USER")
                        .requestMatchers(HttpMethod.POST,"/api/create").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/delete").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/update").hasRole("ADMIN")
        );
        http.csrf((csrf)->
                csrf.disable());
        http.httpBasic(Customizer.withDefaults());
        return http.build();

    }
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}secret")
                .roles("ADMIN")
                .build();
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}secret")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);

    }
 */
}
