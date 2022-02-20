package com.marksouzza.systemproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marksouzza.systemproject.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
