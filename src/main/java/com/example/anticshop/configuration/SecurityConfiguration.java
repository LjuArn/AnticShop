package com.example.anticshop.configuration;//package com.example.mobilele2023new.configuration;


import com.example.anticshop.domain.entity.enums.UserRoleEnum;
import com.example.anticshop.repository.UserRepository;
import com.example.anticshop.service.AnticUserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/users/register", "/users/login", "/users/login-error").permitAll()
                        .requestMatchers("/about", "/error").permitAll()
                        .requestMatchers("/favicon.ico", "/resources/**", "/error").permitAll()
                        .requestMatchers(HttpMethod.GET, "/offers/**").permitAll()
                        .requestMatchers("/users/profile").authenticated()
                        .requestMatchers("/brands").hasRole(UserRoleEnum.ADMIN.name())
                        .anyRequest().authenticated())
                .formLogin(formLogin -> {
                    formLogin.loginPage("/users/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/users/login-error")
                            .permitAll();
                }).logout(logout -> {
                    logout.logoutUrl("/users/logout")
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID");
                });

        return httpSecurity.build();
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }



    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new AnticUserDetailService(userRepository);
    }


}
