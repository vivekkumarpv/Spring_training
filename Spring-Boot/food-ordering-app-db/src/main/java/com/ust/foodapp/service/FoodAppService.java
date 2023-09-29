package com.ust.foodapp.service;

import java.util.List;


import com.ust.foodapp.model.MenuItem;

public interface FoodAppService {
	public MenuItem addItem(MenuItem item);
	public void deleteItem(long id);
	public MenuItem updateItem(long id, MenuItem item);
	public MenuItem searchItemByName(String name);
	public List<MenuItem> displayItems();
	public List<MenuItem> filterByCategory(String category);
	
}
