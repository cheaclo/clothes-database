package com.cheaclo.clothesdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClothesDatabaseApplication {
	@Autowired
	private InitDatabase initDatabase;

	public static void main(String[] args) {
		SpringApplication.run(ClothesDatabaseApplication.class, args);
	}
}
