package com.marksouzza.systemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marksouzza.systemproject.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
