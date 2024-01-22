package com.example.trainingdata.security;

import com.example.trainingdata.repository.TrainerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final TrainerRepository trainerRepository;

    public SecurityConfig(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws
            Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
                .and()
                .addFilterAfter(new XUserIdFilter(this.trainerRepository), SwitchUserFilter.class);

        return http.build();
    }
}
