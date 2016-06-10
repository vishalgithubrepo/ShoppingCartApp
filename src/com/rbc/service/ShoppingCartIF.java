package com.rbc.service;

import java.util.Map;

import com.rbc.model.Item;

public interface ShoppingCartIF {

	public boolean add(Item item, int quantity) throws Exception;
	
	public boolean update(Item item, int quantity) throws Exception;
	
	public boolean remove(Item item, int quantity) throws Exception;
	
	public Map<Item, Integer> getCartItems();
	
	public double checkOut();
	
	public int getItemQty(Item item);
}
