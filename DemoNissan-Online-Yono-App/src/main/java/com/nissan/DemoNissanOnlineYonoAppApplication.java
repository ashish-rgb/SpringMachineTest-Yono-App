package com.nissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoNissanOnlineYonoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNissanOnlineYonoAppApplication.class, args);
		System.out.println("Yono Server Connected");
	}

}
