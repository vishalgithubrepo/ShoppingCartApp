package com.rbc.run;

import com.rbc.model.Item;
import com.rbc.service.ShoppingCart;
import com.rbc.service.ShoppingCartIF;
 
/**
 * This class is used to run/test the Shopping Cart service execution
 * @author Vishal
 *
 */
public class RunShoppingCart {

	public static void main(String[] args) {
		try {
			ShoppingCartIF cart = new ShoppingCart();
			cart.add(Item.APPLE, 4);
			cart.update(Item.APPLE, 1);
			cart.add(Item.MANGO, 10);
			cart.remove(Item.APPLE, 2);
			System.out.println("Total items: " + cart.getItemQty(Item.APPLE));
			System.out.println("Total cost: " + cart.checkOut());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 
