package com.pack.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	User findByNameAndPassword(String name, String password);
	
	Optional<User> findByEmail(String email);
}
