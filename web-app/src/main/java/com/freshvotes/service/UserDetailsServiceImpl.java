package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.freshvotes.domain.Users;
import com.freshvotes.repositories.UserRepository;
import com.freshvotes.security.CustomSecurityUser;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepository.findByUsername(username);
		
		if(users == null) 
			throw new UsernameNotFoundException("Invalid Data..!");
			
		
		return new CustomSecurityUser(users);
	}

}
