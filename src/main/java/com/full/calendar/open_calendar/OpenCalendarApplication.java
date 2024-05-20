package com.full.calendar.open_calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class OpenCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenCalendarApplication.class, args);
	}

}
