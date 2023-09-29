package com.ust.foodapp.repository;

import java.util.List;


import com.ust.foodapp.model.MenuItem;

public interface FoodAppRepo {
	public MenuItem addItem(MenuItem item);
	public void deleteItem(long id);
	public MenuItem updateItem(long id,MenuItem newItem);
	public MenuItem searchItemByName(String name);
	public List<MenuItem> displayItems();
	public List<MenuItem> filterByCategory(String category);
	
	
}
