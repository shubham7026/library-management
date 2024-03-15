package com.ind.lms.config;


import com.ind.lms.repository.interfaces.IUserRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Slf4j
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService(@Autowired IUserRepository iUserRepository) {


        return username -> {
            UserDetails user = iUserRepository.findUserByUsername(username);
            log.info("User : {}", user);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(@Autowired HttpSecurity http) throws Exception {



        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests.requestMatchers("/user").permitAll()
                                .requestMatchers("/user/**").permitAll()
                                .requestMatchers("/student/**").access("hasAnyRole('USER')"))
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();

    }

}
