package com.freshvotes.security;

import java.util.*;

import org.springframework.security.core.userdetails.UserDetails;

import com.freshvotes.domain.Users;


public class CustomSecurityUser extends Users implements UserDetails {

	private static final long serialVersionUID = -8351482943638214015L;

	public CustomSecurityUser() {}
	
	public CustomSecurityUser(Users users) {
		this.setAuthorities(users.getAuthorities());
		this.setId(users.getId());
		this.setUsername(users.getUsername());
		this.setPassword(users.getPassword());
		this.setName(getName());
	}

	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
