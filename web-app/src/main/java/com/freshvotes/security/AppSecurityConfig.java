package com.freshvotes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder getPassordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(getPassordEncoder());

		/*
		 * auth.inMemoryAuthentication() #to use the RAM memory for user names
		 * .passwordEncoder(getPassordEncoder()) .withUser("moraisi")
		 * .password(getPassordEncoder().encode("asdfasdf")) .roles("USER");
		 */

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	  	.authorizeRequests()
	  	.antMatchers("/").permitAll()
	  	.antMatchers("/registeration").permitAll()
	  	.antMatchers("/admin/**").hasRole("ADMIN")
	    .anyRequest().hasRole("USER").and()
	    .formLogin()
	    .loginPage("/login")
	    .defaultSuccessUrl("/dashboard")
	    .permitAll()
	    .and()
	    .logout()
	    .logoutUrl("/logout")
	    .logoutSuccessUrl("/login")
	    .permitAll()
	    ;

	}
}
