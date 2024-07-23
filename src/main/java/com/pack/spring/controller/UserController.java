package com.pack.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pack.spring.dto.RequestResponse;
import com.pack.spring.entity.Product;
import com.pack.spring.repository.ProductRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/public/product")
	public ResponseEntity<Object> getAllProducts() {
		return ResponseEntity.ok(productRepository.findAll());
	}

	@PostMapping("/admin/saveproduct")
	public ResponseEntity<Object> signUp(@RequestBody RequestResponse productRequest) {
		Product productToSave = new Product();
		productToSave.setName(productRequest.getName());
		return ResponseEntity.ok(productRepository.save(productToSave));
	}

	@GetMapping("/user/alone")
	public ResponseEntity<Object> userAlone() {
		return ResponseEntity.ok("USers alone can access this ApI only");
	}

	@GetMapping("/adminuser/both")
	public ResponseEntity<Object> bothAdminaAndUsersApi() {
		return ResponseEntity.ok("Both Admin and Users Can  access the api");
	}

	/**
	 * You can use this to get the details(name,email,role,ip, e.t.c) of user
	 * accessing the service
	 */
	@GetMapping("/public/email")
	public String getCurrentUserEmail() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication); // get all details(name,email,password,roles e.t.c) of the user
		System.out.println(authentication.getDetails()); // get remote ip
		System.out.println(authentication.getName()); // returns the email because the email is the unique identifier
		return authentication.getName(); // returns the email
	}

}
