package com.freshvotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshvotes.domain.Products;

@Repository
public interface ProductRepositorty extends JpaRepository<Products, Integer> {

	

}
