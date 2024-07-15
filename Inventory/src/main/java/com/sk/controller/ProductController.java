package com.sk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.entity.Product;
import com.sk.service.ProductService;

//@RestController
//@RequestMapping("/products")
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	@QueryMapping
	List<Product>  fetchProduct(){
		return productService.getProduct();
	}
	
//	@GetMapping("/{catogery}")
	@QueryMapping
	List<Product> fetchProductByCategory(/* @PathVariable */ @Argument String category){
		return  productService.getProductByCategory(category);
	}
	
	@MutationMapping
	Product updateProductStock(/* @PathVariable */ @Argument int id,@Argument Integer stock){
		return  productService.updateStock(id,stock);
	}
	
	@MutationMapping
	Product newShipment(/* @PathVariable */ @Argument int id,@Argument Integer quantity){
		return  productService.reciveNewShipment(id,quantity);
	}
}
