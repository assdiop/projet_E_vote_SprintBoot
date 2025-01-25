package com.forcen.e_vote.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SecurityConfig {

    private final CustomerUserService customerUserService;

    public SecurityConfig(CustomerUserService customerUserService) {
        this.customerUserService = customerUserService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // pour activer les requetes provenant d'autre domaines, dans le cas du developpement local
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/auth/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                //.oauth2Login(Customizer.withDefaults())
               // .formLogin(Customizer.withDefaults())
                //.addFilterBefore(new JwtFilter(CustomerUserDetailService, jwtUtils), UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    //pour permettre de crytper le mot de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManager = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManager.userDetailsService(customerUserService).passwordEncoder(passwordEncoder);
        return authenticationManager.build();
    }

}
