package com.sk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dto.Item;
import com.sk.dto.ItemReturnDTO;
import com.sk.service.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	
	@GetMapping("/product")
	public List<Item> viewProduct(){
		return catalogService.viewProduct();
	}
	
	@GetMapping("/product/category")
	public List<Item> viewProduct(@RequestParam String category){
		return catalogService.viewProductBy(category);
	}
	

	@PostMapping("/shipment")
	public Item viewProduct(@RequestBody ItemReturnDTO itemReturnDTO){
		return catalogService.reciveNewShipmewnt(itemReturnDTO);
	}
	
}
