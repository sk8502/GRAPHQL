package com.sk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.entity.Product;
import com.sk.repository.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getProduct(){
		return productRepository.findAll();
	}
	
	public List<Product> getProductByCategory(String category){
		return productRepository.findByCategory(category);
	}
	
	//sales team update the stock of products
	public Product updateStock(int id,Integer stock) {
	Product existingProduct=   productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id" +id));	
	 existingProduct.setStocks(stock);
	return productRepository.save(existingProduct);
	}
	
	
	public Product reciveNewShipment(int id,Integer quantity) {
		Product existingProduct=   productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id" +id));	
		 existingProduct.setStocks(existingProduct.getStocks()+quantity);
		return productRepository.save(existingProduct);
		}
	
}
