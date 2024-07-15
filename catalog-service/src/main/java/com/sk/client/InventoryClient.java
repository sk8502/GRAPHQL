package com.sk.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import com.sk.dto.Item;
import com.sk.dto.ItemReturnDTO;

import reactor.core.publisher.Mono;

@Component
public class InventoryClient {

	@Autowired
	private HttpGraphQlClient graphQlClient;
	
     public	List<Item> viewProduct(){
		String graphQLQuery="query FetchProduct{\r\n"
				+ "    fetchProduct{\r\n"
				+ "        name\r\n"
				+ "        price\r\n"
				+ "    }\r\n"
				+ "}";
		
	List<Item>product=graphQlClient.document(graphQLQuery).retrieve("fetchProduct").toEntityList(Item.class).block();
    	 return product;
     }
	
	public List<Item> viewProductsBycatogery(String category){
		String graphQLquery=String.format("query FetchProductByCategory{\r\n"
				+ "    fetchProductByCategory(category:\"%s\"){\r\n"
				+ "        name\r\n"
				+ "        category\r\n"
				+ "        price\r\n"
				+ "        stocks\r\n"
				+ "\r\n"
				+ "    }\r\n"
				+ "}",category);
		
		
		List<Item>product=graphQlClient.document(graphQLquery).retrieve("fetchProductByCategory").toEntityList(Item.class).block();
	    	 return product;
	}
	
	//mutation method
	
	public Item newShipment(ItemReturnDTO itemReturnDTO) {
		String geaphQLQuery=String.format("mutation MyMutation {\r\n"
				+ "		  newShipment(id: %s, quantity: %d) {\r\n"
				+ "		    stocks\r\n"
				+ "		    price\r\n"
				+ "		    name\r\n"
				+ "		  }\r\n"
				+ "		}",itemReturnDTO.getId(),itemReturnDTO.getQty());
		
	return	graphQlClient.document(geaphQLQuery).retrieve("newShipment")
		            .toEntity(Item.class).block();          
		
	}
	
     
     
}
