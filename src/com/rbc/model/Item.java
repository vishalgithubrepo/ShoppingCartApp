package com.rbc.model;

/**
 * This enum is used to store the items with price for user to pick/select
 * @author Vishal
 *
 */
public enum Item {
 
       ORANGE("Orange", 10.0f), APPLE("Apple", 20.0f), MANGO("Mango", 30.0f);
 
       private Item(String name, float price) {
              this.name = name;
              this.price = price;
       }
 
       private String name;
       private double price;
 
       public String getName() {
              return name;
       }
 
       public double getPrice() {
              return price;
       }
}
 