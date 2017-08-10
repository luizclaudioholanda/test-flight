package com.testeatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableConfigurationProperties
public class TesteAtechApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] { TesteAtechApplicationTest.class, DBConfig.class }, args);
	}
}
