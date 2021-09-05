package com.bridgelabz.employeepayrollspringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
public class EmployeePayrollSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(EmployeePayrollSpringBootApplication.class, args);
		log.info("Application Started Successfully. in {} Enviroment",context.getEnvironment().getProperty("environment"));
	}

}
