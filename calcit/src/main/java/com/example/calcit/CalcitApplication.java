package com.example.calcit;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CalcitApplication {

		public static void main(String[] args) {
			SpringApplication.run(CalcitApplication.class, args);
			// String url = "jdbc:mysql://localhost:3306/calcit?useSSL=false";
			// try {
			// 	String username = "root";
			// 	String password = "";
			// 	Connection c = DriverManager.getConnection(url, username, password);
			// 	System.out.println("DZIALA");

			// } catch (Exception e) {
			// 	System.out.println("NIE DZIALA " + e.getMessage());
			// }
		}
}
