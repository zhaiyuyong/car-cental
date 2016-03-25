package com.xxx.car;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@Order(HIGHEST_PRECEDENCE)
public class CarApplication {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CarApplication.class,args);
		FilterSecurityInterceptor fsi;
		HandlerMethodArgumentResolver handlerMethodArgumentResolver;
		HandlerMethodArgumentResolverComposite HandlerMethodArgumentResolverComposite;
		DefaultSecurityFilterChain defaultSecurityFilterChain;
		AnyRequestMatcher AnyRequestMatcher;
		DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler;
	}
}
