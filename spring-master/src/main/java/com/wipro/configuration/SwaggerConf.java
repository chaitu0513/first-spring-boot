package com.wipro.configuration;

import java.sql.Date;
import java.time.Instant;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import com.fasterxml.classmate.TypeResolver;

import lombok.NoArgsConstructor;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@NoArgsConstructor
public class SwaggerConf {

	  @Bean
	    public Docket api() { 
		  TypeResolver typeResolver = new TypeResolver();
	        return new Docket(DocumentationType.SWAGGER_2)  
	        		.alternateTypeRules( AlternateTypeRules.newRule(
	                        typeResolver.resolve(Collection.class, Instant.class),
	                        typeResolver.resolve(Collection.class, Date.class), Ordered.HIGHEST_PRECEDENCE))
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("com.wipro"))              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
	
}