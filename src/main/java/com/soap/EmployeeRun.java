package com.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@ComponentScan
@EnableWebMvc
@Configuration
@SpringBootApplication
public class EmployeeRun {

	/*public EmployeeRun() {
		// TODO Auto-generated constructor stub
	}
*/
	public static void main(String args[]) {
		SpringApplication.run(EmployeeRun.class,args);
	}
}
