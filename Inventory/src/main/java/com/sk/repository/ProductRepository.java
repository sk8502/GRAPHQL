package com.sk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(String catogery);

}
