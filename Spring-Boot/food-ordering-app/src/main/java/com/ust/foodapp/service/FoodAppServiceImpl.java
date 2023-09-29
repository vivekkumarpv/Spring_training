package com.ust.foodapp.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.foodapp.model.MenuItem;
import com.ust.foodapp.model.MenuItem.Category;
import com.ust.foodapp.model.MenuItem.Status;
import com.ust.foodapp.repository.FoodAppRepo;

@Service
public class FoodAppServiceImpl implements FoodAppService {
	
	@Autowired
	FoodAppRepo repo;
	
	@PostConstruct
	public void init() {
		MenuItem item1= new MenuItem(1001,"Biriyani", Status.AVAILABLE, 150, Category.NONVEG);
		MenuItem item2 = new MenuItem(1002,"Fried Rice", Status.NOTAVAILABLE, 130, Category.NONVEG);
		MenuItem item3 = new MenuItem(1003,"Meals", Status.AVAILABLE,80, Category.VEG);
		repo.addItem(item1);
		repo.addItem(item2);
		repo.addItem(item3);
	}
	
	@Override
	public MenuItem addItem(MenuItem item) {
		MenuItem AddedItem=repo.addItem(item);
		return AddedItem;
	}

	@Override
	public void deleteItem(long id) {
		repo.deleteItem(id);
		
	}

	@Override
	public MenuItem updateItem(long id, MenuItem item) {
		MenuItem updatedItem=repo.updateItem(id, item);
		return updatedItem;
	}

	@Override
	public MenuItem searchItemByName(String name) {
		MenuItem item=repo.searchItemByName(name);
		return item;
	}

	@Override
	public List<MenuItem> displayItems() {
		return repo.displayItems();
	}

	@Override
	public List<MenuItem> filterByCategory(String category) {
		return repo.filterByCategory(category);
	}

}
