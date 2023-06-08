package com.tave.music.config;

import com.tave.music.config.auth.CustomOAuth2UserService;
import com.tave.music.domain.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/main", "/login").permitAll()
                .antMatchers("/admin/**").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated()

                .and()
                    .logout()
                        .logoutSuccessUrl("/main")

                .and()
                    .oauth2Login()
                        .loginPage("/login")
                        .defaultSuccessUrl("/main")
                        .userInfoEndpoint()
                        .userService(customOAuth2UserService);

        return http.build();
    }
}
