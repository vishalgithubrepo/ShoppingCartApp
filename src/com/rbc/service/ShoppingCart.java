package com.rbc.service;

import java.util.HashMap;
import java.util.Map;

import com.rbc.model.Item;

/**
 * This class is implementation of shopping cart to handle/perform functions - add, update, remove, checkout
 * @author Vishal
 *
 */
public class ShoppingCart implements ShoppingCartIF {

	//Used to store cartItems
	private Map<Item, Integer> cartItems;

	public ShoppingCart() {
		cartItems = new HashMap<Item, Integer>();
	}

	/**
	 * This method is used to add items and quantity to cart
	 * @param item		Item to add to cart
	 * @param quantity	Quantity to add to cart for item
	 * @return result	Item addition result
	 * @throws Exception
	 */
	public boolean add(final Item item, final int quantity) throws Exception {
		boolean result = true;
		if (cartItems.containsKey(item)) {
			result = false;
			throw new Exception(
					"Item = "
							+ item
							+ " already exists in cart!!!. Please perform update to update quantity ");
		} else {
			if(quantity < 0) {
				result = false;
				throw new Exception(
						"Quantity cannot be less than 0. Please correct the quantity & perform add ");
			}
			cartItems.put(item, quantity);
			result = true;
		}
		return result;
	}

	/**
	 * This method is used to update item quantity in cart
	 * @param item		Item to update in cart
	 * @param quantity	Quantity to update from cart for item
	 * @return result	Item updation result
	 * @throws Exception
	 */
	public boolean update(final Item item, final int quantity) throws Exception {
		boolean result = false;
		if (cartItems.isEmpty()) {
			result = false;
			throw new Exception(
					"Empty cart !!!. Please add items to update cart");
		}
		if (cartItems.containsKey(item)) {
			if(quantity < 0) {
				result = false;
				throw new Exception(
						"Quantity cannot be less than 0. Please correct the quantity & perform update ");
			}
			int existingQuantity = cartItems.get(item);
			cartItems.put(item, quantity + existingQuantity);
			result = true;
		} else {
			result = false;
			throw new Exception(
					"Item = "
							+ item
							+ " does not exists in cart !!!. Please add this item & then perform update");
		}
		return result;
	}

	/**
	 * This method is used to remove items from cart
	 * @param item		Item to remove from cart
	 * @param quantity	Quantity to remove from cart for item
	 * @return result	Item removal result			
	 * @throws Exception
	 */
	public boolean remove(final Item item, final int quantity) throws Exception {
		boolean result = false;
		if (cartItems.isEmpty()) {
			result = false;
			throw new Exception(
					"Empty cart!!!. Please add items first to cart to remove");
		}
		int existingQuantity = 0;
		if (cartItems.containsKey(item)) {
			if(quantity < 0) {
				result = false;
				throw new Exception(
						"Quantity cannot be less than 0. Please correct the quantity & perform remove ");
			}
			existingQuantity = cartItems.get(item);
			if (existingQuantity < quantity) {
				result = false;
				throw new Exception(
						"Insufficient quantity to remove for item = " + item);
			}
			if (existingQuantity == quantity) {
				cartItems.remove(item);
			} else {
				// update cart quantity of item
				cartItems.put(item, (existingQuantity - quantity));
			}
			result = true;
		}

		return result;
	}

	/**
	 * This method return all items in cart
	 * @return cartItems	all items in the shopping cart
	 */
	public Map<Item, Integer> getCartItems() {
		return cartItems;
	}
	
	/**
	 * This method is used to calculate the total cost of the cart items
	 * @return totalCost	totalCost of Shopping Cart
	 */
	public double checkOut() {
		double totalCost = 0.0f;

		if (!cartItems.isEmpty()) {
			for (Item item : cartItems.keySet()) {
				totalCost = totalCost + (item.getPrice() * cartItems.get(item));
			}
		}

		return totalCost;
	}
	
	/**
	 * This method is used to return quantity for given Item
	 * @param item	Item for which quantity needs to be determined
	 * @return qty	Item quantity
	 */
	public int getItemQty(final Item item) {
		int qty = 0;
		if (!cartItems.isEmpty() && cartItems.containsKey(item)) {
			qty = cartItems.get(item);
		}
		return qty;
	}

}