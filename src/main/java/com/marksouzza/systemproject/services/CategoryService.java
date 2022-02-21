package com.marksouzza.systemproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marksouzza.systemproject.domain.Category;
import com.marksouzza.systemproject.repositories.CategoryRepository;
import com.marksouzza.systemproject.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public Category find(Integer id) {
		Optional<Category> obj=repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
						"Objeto não encontrado! ID: " + id + ", Tipo: " + Category.class.getName()));
		}
	
	}

