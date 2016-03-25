package com.xxx.car.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
public class PropertiesConfiguration {

	
	@Configuration
    @Profile(AppProfile.INTG)
    @PropertySource(value = {"classpath:/intg/jdbc.properties"})
    static class ServiceIntgConfiguration {
    }

    @Configuration
    @Profile(AppProfile.PROD)
    @PropertySource(value = {"classpath:/prod/jdbc.properties"})
    static class ServiceProdAConfiguration {
    }
    
    @Autowired
    private Environment env;
}
