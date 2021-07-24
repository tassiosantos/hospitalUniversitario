package com.hospital.hospital_universitario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan
@CrossOrigin
public class HospitalUniversitarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalUniversitarioApplication.class, args);
	}

}
