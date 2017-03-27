package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class AspApplication extends SpringBootServletInitializer implements CommandLineRunner {

	private SomeTest st = new SomeTest();

	public static void main(String[] args) {
		SpringApplication.run(AspApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<AspApplication> applicationClass = AspApplication.class;

	@Override
	public void run(String... strings) throws Exception {
		System.out.println(st.someMethod());
	}

	@RestController
	class GreetingController {

		@RequestMapping("/hello")
		String hello() {
			return "Hello, " + st.someMethod() + "!";
		}
	}

}
