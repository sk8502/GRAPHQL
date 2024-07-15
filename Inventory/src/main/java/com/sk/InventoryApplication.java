package com.sk;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sk.entity.Product;
import com.sk.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class InventoryApplication {

	
//	@Autowired
//	private ProductRepository repository;
//
//	@PostConstruct
//	public void defineInitDB() {
//		
//		List<Product> products=Stream.of(new Product("laptop","Electronic",737373f,45),
//				new Product("mobile","Electronic",66666f,88),
//				new Product("water bottel","accessories",666f,22)
//				).collect(Collectors.toList());			
//		 repository.saveAll(products);
//	}
	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}
}
