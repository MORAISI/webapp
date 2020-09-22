package com.freshvotes.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.freshvotes.domain.Users;

@Entity
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 4891041731378986151L;
	
	private int id;
	private Users users;
	private String authority;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}

}
