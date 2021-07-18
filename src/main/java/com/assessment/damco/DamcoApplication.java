package com.assessment.damco;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
public class DamcoApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(DamcoApplication.class);

		Environment environment = application.run(args).getEnvironment();

		log.info("\n----------------------------\n\t" +
				"Application access URL : http://localhost:{}{}swagger-ui.html \n----------------------------",environment.getProperty("server.port"),environment.getProperty("server.servlet.context-path"));


	}

}
