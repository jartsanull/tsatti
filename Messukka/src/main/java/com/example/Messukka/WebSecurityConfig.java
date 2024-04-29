package com.example.Messukka;


import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;


import com.example.Messukka.web.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	

	@Autowired
    private UserDetailServiceImpl userDetailsService;
	

	    @Bean
	    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	       http
	            .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
	                .authenticated()
	            )
	            .httpBasic(withDefaults())
	            .formLogin(withDefaults())
	            .csrf(AbstractHttpConfigurer::disable)
	            .formLogin(formlogin -> formlogin
	                .defaultSuccessUrl("/chat", true)
	                .permitAll()
	            )
	            .logout(logout -> logout
	                .permitAll()
	            );
	      return http.build();
	    }

	@Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    }
    
    


   
}


