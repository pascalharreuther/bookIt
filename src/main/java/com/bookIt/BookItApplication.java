package com.bookIt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;

@SpringBootApplication
public class BookItApplication {

	private static ConfigurableApplicationContext applicationContext = null;
	private static MessageSource messageSource;

	public static void main(String[] args) {
		final SpringApplication app = new SpringApplication(BookItApplication.class);
		applicationContext = app.run(args);
		messageSource = (MessageSource) applicationContext.getBean("messageSource");
	}

}
