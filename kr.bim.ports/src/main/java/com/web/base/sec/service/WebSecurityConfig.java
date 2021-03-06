package com.web.base.sec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthProvider authProvider;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**, /static/**, *.ico");	
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
         .antMatchers("/system/**").authenticated()
         .antMatchers("/account/login/**").permitAll() // this is the line I added
         ;
       
	
			/*
			 * http.formLogin() .loginPage("/account/login") .defaultSuccessUrl("/home")
			 * .usernameParameter("id") .passwordParameter("password");
			 * 
			 * http.logout() .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			 * .logoutSuccessUrl("/") .invalidateHttpSession(true);
			 */
		
		http.authenticationProvider(authProvider);
		
	}

}
