package com.jpa.application.jpa.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String...data)
	{
		companyRepository.save(new Company("Samsung",6,"Web Developer",25000,false));

		companyRepository.save(new Company("Google",3,"Android Developer",50000,true));

		companyRepository.save(new Company("Byjus",6,"Software Developer",8000,false));

		companyRepository.save(new Company("GFG",12,"Backend Developer",2500,true));

		companyRepository.save(new Company("Reliance",3,"Marketing",15000,false));

		System.out.println(companyRepository.findById(3));
		System.out.println(companyRepository.findByDuration(6));
	}

}
