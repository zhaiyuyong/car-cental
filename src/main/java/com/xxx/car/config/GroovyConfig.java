package com.xxx.car.config;

import static org.springframework.core.Ordered.LOWEST_PRECEDENCE;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

import com.xxx.car.DynamicDeployBeans;
import com.xxx.car.DynamicDeployBeans2;

@Configuration
//@ImportResource(value={"classpath:spring-groovy.xml"})
@Order(LOWEST_PRECEDENCE)
public class GroovyConfig {
	
	@Autowired
	private DynamicDeployBeans dynamicDeployBeans;
	@Autowired
	private DynamicDeployBeans2 dynamicDeployBeans2;

	@PostConstruct
	public void init() throws IOException{
		dynamicDeployBeans.registerGroovyController("file:/Users/zhaiyuyong/Documents/workspace/circuit-breaker-sample/src/test/resources/HelloWorldController.groovy");
	}
}
