package com.example.pathfinder.config;

import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.PathfinderUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .permitAll()
                .requestMatchers("/")
                .permitAll()
                .requestMatchers("/user/register","/user/login").anonymous()
                .anyRequest().authenticated());


        http.formLogin(login -> login
                .loginPage("/user/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                //success forward url is post request
                .successForwardUrl("/user/login-success")
                .failureUrl("/user/login-error"));

        http.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new PathfinderUserDetailsService(userRepository);
    }
}
