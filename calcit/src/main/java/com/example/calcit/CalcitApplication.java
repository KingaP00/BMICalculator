package com.example.calcit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CalcitApplication {

		public static void main(String[] args) {
			SpringApplication.run(CalcitApplication.class, args);
		}
}
