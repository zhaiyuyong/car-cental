package com.xxx.car.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.FilterRegistration.Dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;


@Configuration
public class ServletConfig extends SpringBootServletInitializer{
	
	
	@Autowired
	ServletContext servletContext;
	
	
	@PostConstruct
	public void init(){
		// TODO 这里改为只监控 /api, /clientapi 的数据？
	    WebStatFilter druidWebStatFilter = new WebStatFilter();
	    Dynamic filter = servletContext.addFilter("druidWebStatFilter", druidWebStatFilter);
	    filter.setInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
	    filter.addMappingForUrlPatterns(null, true, "/*");
	}

	@Bean
	@Order
	public ServletRegistrationBean statViewServlet() {
		StatViewServlet servlet = new StatViewServlet();
		ServletRegistrationBean bean = new ServletRegistrationBean(servlet, "/druid/*");
		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("resetEnable", "true");
		initParameters.put("loginUsername", "druid");
		initParameters.put("loginPassword", "druid");
		bean.setInitParameters(initParameters);
		return bean;
	}
	
	//@Bean
	public FilterRegistrationBean webStatFilter(){
		WebStatFilter druidWebStatFilter = new WebStatFilter();
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.addInitParameter("exclusions", ".js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		bean.setFilter(druidWebStatFilter);
		bean.setEnabled(true);
		bean.addUrlPatterns("/*");
		return bean;
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ServletConfig.class);
	}
	
	
}
