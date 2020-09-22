package com.freshvotes.domain;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Products {
	
	private int id;
	private String productname;
	private Users users; 								// product belong to only one user manyToOne relationship
	private Set<Features> feature = new HashSet<>();   // product have many features OneToMany relationship
	private boolean Published;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	@ManyToOne
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "products") //cascade all if you delete product all features will be deleted
	public Set<Features> getFeature() {
		return feature;
	}
	public void setFeature(Set<Features> feature) {
		this.feature = feature;
	}
	public boolean isPublished() {
		return Published;
	}
	public void setPublished(boolean published) {
		Published = published;
	}
	
	
	
	
	

}
