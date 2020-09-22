package com.freshvotes.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetailsServiceTest {
	 @Test
	 public void generat_encrypt_password() {
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 String rawPassword = "04544045";
		 String encodedPasswordString= encoder.encode(rawPassword);
		 
		 System.out.println(encodedPasswordString);
		 
		 Assert.assertNotEquals(rawPassword, encodedPasswordString);
	
	 }

}
