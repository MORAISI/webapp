package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshvotes.domain.Products;
import com.freshvotes.repositories.ProductRepositorty;

@Service
public class ProductService {
	@Autowired
	private ProductRepositorty productRepositorty;

	public Products SaveProduct(Products products) {
		products.setProductname(products.getProductname());

		return productRepositorty.save(products);

	}

}
