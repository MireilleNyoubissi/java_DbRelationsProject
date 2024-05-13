package com.dbRelation.db_relationProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DbRelationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbRelationProjectApplication.class, args);
	}

}
