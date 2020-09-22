package com.freshvotes.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.freshvotes.security.Authority;

@Entity
@Table(name = "Users")

public class Users {
	private int id;
	private String username;
	private String password;
	private String name;
	private String email;
	private Set<Authority> authorities = new HashSet<>();
	private Set<Products> Products = new HashSet<>();    // user have many products one to many 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", authorities=" + authorities + "]";
	}
	
	
	@OneToMany(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY  , mappedBy = "users") //cascade persist not delete the products
	public Set<Products> getProducts() {
		return Products;
	}

	public void setProducts(Set<Products> products) {
		Products = products;
	}
	
	

}
