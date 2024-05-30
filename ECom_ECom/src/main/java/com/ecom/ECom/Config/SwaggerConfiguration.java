//package com.ecom.ECom.Config;
//
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class SwaggerConfiguration {
//	
//	@Bean
//	public Docket api() {
//		
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build()
//				.apiInfo(apiInfo());
//	}
//	
//	private ApiInfo apiInfo() {
//		return new ApiInfo(
//				"Web Service for Authors",
//				"The Project Contains APIs for managing Customers information",
//				"API v1",
//				"These are my terms of service",
//				new Contact("Developer", "www.webaddres.com", "abc@emailprovider.com"),
//				"This is the license of API",
//				"www.mylicensekey.com",
//				Collections.emptyList()
//				);
//	}
//}
