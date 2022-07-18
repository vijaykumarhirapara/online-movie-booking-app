package com.vijay.booking.controller.moviebookingapi.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.vijay.booking.controller.moviebookingapi.controller"))
	      .build()
	      .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	    		"Movie booking app",
	    		"Online movie booking API",
	    		"API V1", "Terms of service",
	    		new springfox.documentation.service.Contact("Vijaykumar Hirapara", "www.vijay.com", "hiraparavijay@gmal.com"),
	    		"License of API", "API license URL", Collections.emptyList());
	}

}
