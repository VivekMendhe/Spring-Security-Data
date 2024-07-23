package com.pack.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
