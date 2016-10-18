package com.groupfive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;


@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{ 
	@Bean
	public SpringTemplateEngine getTemplateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(getTemplateResolver());
		return templateEngine;
	}//end SpringTemplateEngine
	
	@Bean
	public ThymeleafViewResolver getViewResolver(){
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(getTemplateEngine());
		return resolver;	
	}//end ThymeleafViewResolver
	
	@Bean
	public SpringResourceTemplateResolver getTemplateResolver(){
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/view/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("LEGACYHTML5");
		templateResolver.setCacheable(false);
		return templateResolver;
	}//end SpringResourceTemplateResolver
	

}//end class
