package com.xxx.car.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages={"com.xxx.car.persistence"})
public class DatasourceConfig {
	
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DatasourceConfig.class);

	
	private static final String MYSQL_PREFIX = "mysql.";
	private static final String DRUID_PREFIX = "druid.";
	
    @Autowired
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
    	LOGGER.info("----begin init datasource----");
        Properties dbProperties = new Properties();
        Map<String, Object> map = new HashMap<String, Object>();
        for (Iterator<PropertySource<?>> it = ((AbstractEnvironment) env).getPropertySources().iterator(); it.hasNext();) {
            PropertySource<?> propertySource = it.next();
            getPropertiesFromSource(propertySource, map);
        }
        dbProperties.putAll(map);
        
        DruidDataSource dataSource = null;
        try {
        	dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(dbProperties);
        	if(null != dataSource) {
        		dataSource.setFilters("wall,stat");
//        		dataSource.setTimeBetweenLogStatsMillis(5000);
        		dataSource.init();
        	}
        } catch (Exception e) {
        	throw new RuntimeException("load datasource error, dbProperties is :" + dbProperties, e);
        }
        LOGGER.info("----end init datasource----");
        StringBuilder sb=new StringBuilder(""); 
        Exception e = new Exception("zhaiyuyong"); 
        StackTraceElement[] trace = e.getStackTrace();; 
        for (int i=0; i < trace.length; i++){ 
            sb.append("\tat " + trace[i]);
        }
        System.out.println("who invoke me  \n"+sb.toString());
        return dataSource;
    }
    
    private void getPropertiesFromSource(PropertySource<?> propertySource, Map<String, Object> map) {
    	
        if (propertySource instanceof MapPropertySource) {
            for (String key : ((MapPropertySource) propertySource).getPropertyNames()) {
            	if (key.startsWith(MYSQL_PREFIX)) {
					map.put(key.replaceFirst(MYSQL_PREFIX, ""), propertySource.getProperty(key));
				} else if (key.startsWith(DRUID_PREFIX)) {
					map.put(key.replaceFirst(DRUID_PREFIX, ""), propertySource.getProperty(key));
				}
            }
        }
        
        if (propertySource instanceof CompositePropertySource) {
            for (PropertySource<?> s : ((CompositePropertySource) propertySource).getPropertySources()) {
                getPropertiesFromSource(s, map);
            }
        }
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager() {
    	LOGGER.info("DataSourceTransactionManager--begin to set dataSource--");
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        LOGGER.info("SqlSessionFactory--begin to set dataSource--");
        sqlSessionFactory.setDataSource(dataSource());
        Resource resource = new ClassPathResource("database/mybatis-config.xml");
        sqlSessionFactory.setConfigLocation(resource);
        return sqlSessionFactory.getObject();
    }
    
    
    @Bean
    public TransactionTemplate transactionTemplate(){
    	TransactionTemplate transactionTemplate = new TransactionTemplate();
    	transactionTemplate.setTransactionManager(transactionManager());
    	return transactionTemplate;
    }
    
    
}
