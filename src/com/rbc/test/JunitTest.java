package com.rbc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.rbc.model.Item;
import com.rbc.service.ShoppingCart;
import com.rbc.service.ShoppingCartIF;

public class JunitTest {

	private static ShoppingCartIF cart;

	@Before
	public void setUp() throws Exception {
		cart = new ShoppingCart();
		addProduct();
	}

	@Test
	public void testAddProduct() throws Exception {
		assertEquals(15, cart.getItemQty(Item.APPLE));
	}

	private static void addProduct() throws Exception {
		cart.add(Item.APPLE, 15);
		cart.add(Item.MANGO, 10);
		cart.add(Item.ORANGE, 20);
	}

	@Test
	public void testRemoveProduct() throws Exception {
		cart.remove(Item.ORANGE, 10);
		assertEquals(10, cart.getItemQty(Item.ORANGE));
	}

	@Test
	public void testUpdateItem() throws Exception {
		cart.update(Item.ORANGE, 10);
		assertEquals(30, cart.getItemQty(Item.ORANGE));
	}

	@Test
	public void testCheckOut() throws Exception {
		assertEquals(true, (800.0 == cart.checkOut()));
	}

}