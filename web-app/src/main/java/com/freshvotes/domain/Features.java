package com.freshvotes.domain;

import javax.persistence.*;

@Entity
@Table(name = "Features")
public class Features {
	private Long id;
	private String title;
	private String description;
	private Products products;   //product can have many feature manyToOne
	private String status;

	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	
	

}
