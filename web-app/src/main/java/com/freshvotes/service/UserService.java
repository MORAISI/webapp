package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.freshvotes.domain.Users;
import com.freshvotes.repositories.UserRepository;
import com.freshvotes.security.Authority;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	 

	public Users saveUsers(Users users) {
	String encodeedPassword = encoder.encode(users.getPassword());
	users.setPassword(encodeedPassword);
	Authority authority = new Authority();
	authority.setAuthority("ROLE_USER");
	authority.setUsers(users);
	users.getAuthorities().add(authority);

		return userRepository.save(users);

	}

}
