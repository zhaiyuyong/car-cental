package com.xxx.car.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CarSecurityFilter filter = new CarSecurityFilter();
		http.addFilterBefore(filter, BasicAuthenticationFilter.class);
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.logout().disable();
		
		
		http
		.authorizeRequests()
		.antMatchers("/api/user3/my").hasAnyAuthority("MY")
		.antMatchers("/api/user3/you").hasAnyAuthority("ROLE_ANONYMOUS","MY");
		
		/**
		http.antMatcher("/api/user/**")
		.authorizeRequests()
		.antMatchers("/api/user/my").hasRole("MY")
		.antMatchers("/api/user/you").hasAnyRole("ANONYMOUS","MY");
		**/
		//http.antMatcher("");
		//http.requestMatchers();
		//http.regexMatcher("");
		
	}
	
    //@Configuration
	//@Order(1)
	public static class ApiSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.logout().disable();
			http.antMatcher("/api/user/**").authorizeRequests().anyRequest().hasAnyAuthority("USER");
		}
	} 
    
    //@Configuration
	//@Order(3)
	public static class Api2SecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.logout().disable();
			http.requestMatchers().antMatchers("/api/zhaiyuyong/**","/api/sw/**").and().authorizeRequests().anyRequest().hasAnyAuthority("ZYY");
		}
	} 
    
    
    //@Configuration
	//@Order(2)
	public static class WebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.logout().disable();
			http.authorizeRequests().antMatchers("/api/web/**").hasAnyAuthority("WEB");
		}
	}
	
}
