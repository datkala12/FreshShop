package com.freshshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class FreshShopSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/cart").authenticated()
                .requestMatchers("/profile").authenticated()
                .requestMatchers("/addToCart").authenticated()
                .requestMatchers("/viewCart").authenticated()
                .requestMatchers("/admin/**").authenticated()
                .requestMatchers("/admin/**").permitAll()
                .requestMatchers("/shop/**").permitAll()
                .requestMatchers("/error").permitAll()
                .requestMatchers("/shop/page/**").permitAll()
                .requestMatchers("/getProductsByCate").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/shop-detail").permitAll()
                .requestMatchers("/displayDetail").permitAll()
                .requestMatchers("/checkout").authenticated()
                .requestMatchers("/placeOrder").authenticated()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/report/**").hasRole("ADMIN")
                .requestMatchers("/report").hasRole("ADMIN")
                .requestMatchers("/login").permitAll()
                .requestMatchers("/logout").permitAll()
                .requestMatchers("/register").permitAll()
                .requestMatchers("/public/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
