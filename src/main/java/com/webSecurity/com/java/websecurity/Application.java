package com.webSecurity.com.java.websecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters =
@ComponentScan.Filter(type=FilterType.REGEX,
		pattern="com\\.webSecurity\\.com\\.java\\.websecurity\\.BasicAuth\\..*"))

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
