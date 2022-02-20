package com.marksouzza.systemproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marksouzza.systemproject.domain.Category;
import com.marksouzza.systemproject.repositories.CategoryRepository;

@SpringBootApplication
public class SystemprojectApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SystemprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}
