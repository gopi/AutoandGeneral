package com.autogeneral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class AutoGeneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoGeneralApplication.class, args);
	}


	@Bean
	public Docket swaggerConfiguration() {
		// Return a prepared Docket instance

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.autogeneral"))
                .paths(PathSelectors.any())
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Auto & General test API",
				"This is an example implementation of API for testing candidates",
				"1.0",
				"",
				new springfox.documentation.service.Contact("Gopi Sundar Raj", "https://www.linkedin.com/in/gopi-s-3786416/", "gopi.sv14@gmail.com"),
				"API License",
				"http://www.autogeneral.com.au",
				Collections.emptyList());
	}
}