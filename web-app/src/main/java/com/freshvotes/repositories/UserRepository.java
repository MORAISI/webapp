package com.freshvotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshvotes.domain.Users;


//jpa is a repository to do the CRUD process for us
// to be used in the services
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);
	

}
