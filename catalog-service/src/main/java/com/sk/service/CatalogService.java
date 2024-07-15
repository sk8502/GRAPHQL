package com.sk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.client.InventoryClient;
import com.sk.dto.Item;
import com.sk.dto.ItemReturnDTO;

@Service
public class CatalogService {

	
	@Autowired
	private InventoryClient inventoryClient;
	
	public List<Item> viewProduct(){
		return inventoryClient.viewProduct();
	}
	
	public List<Item> viewProductBy(String category){
		return inventoryClient.viewProductsBycatogery(category);
	}
	
	public Item reciveNewShipmewnt(ItemReturnDTO itemReturnDTO){
		return inventoryClient.newShipment(itemReturnDTO);
	}
	
}
