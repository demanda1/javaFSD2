package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users=User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("1234").roles("employee"))
		.withUser(users.username("smith").password("1234").roles("employee","admin"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
		.antMatchers("/").hasRole("employee")
		.antMatchers("/view").hasRole("employee")
		.antMatchers("/systems").hasRole("admin").and().formLogin().and().logout().permitAll();
	}

	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.csrf().disable()
//			.authorizeRequests().antMatchers("/login").permitAll()
//			.anyRequest().authenticated();
//	}

//	@Bean //since we want to use the object of the UserDetails Service
//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		List<UserDetails> users=new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("deepak").password("1234").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(users);
//	}
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	public AuthenticationProvider authProvider() {
//		
//		
//		
//		//responsible for talking to db and verify the details
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		return provider;
//	}
	
	

}
