package com.ust.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.foodapp.exceptionhandling.InvalidCategoryException;
import com.ust.foodapp.exceptionhandling.ItemNotFoundException;
import com.ust.foodapp.model.MenuItem;
import com.ust.foodapp.model.MenuItem.Category;
import com.ust.foodapp.repository.FoodAppRepo;

@Service
public class FoodAppServiceImpl implements FoodAppService {
	
	@Autowired
	FoodAppRepo repo;
	
//	@PostConstruct
//	public void init() {
//		MenuItem item1= new MenuItem(1001,"Biriyani", Status.AVAILABLE, 150, Category.NONVEG);
//		MenuItem item2 = new MenuItem(1002,"Fried Rice", Status.NOTAVAILABLE, 130, Category.NONVEG);
//		MenuItem item3 = new MenuItem(1003,"Meals", Status.AVAILABLE,80, Category.VEG);
//		repo.addItem(item1);
//		repo.addItem(item2);
//		repo.addItem(item3);
//	}
	
	
	public MenuItem addItem(MenuItem item) {
		if(repo.existsById(item.getMenuItemId())) {
			throw new ItemNotFoundException("Item " +item.getItemName()+" already exist");
		}
		MenuItem AddedItem=repo.save(item);
		return AddedItem;
	}

	
	public void deleteItem(long id) {
		if(!repo.existsById(id)) {
			throw new ItemNotFoundException("Item With name "+id+" not found");
		}
		repo.deleteById(id);
		
	}

	
	public MenuItem updateItem(long id, MenuItem item) {
		if(!repo.existsById(id)) {
			throw new ItemNotFoundException("Item With name "+id+" not found");
		}
		MenuItem updatedItem=repo.save(item);
		return updatedItem;
	}

	
	public MenuItem searchItemByName(String itemName) {
		MenuItem item=repo.findByItemName(itemName).orElseThrow(()->
				new ItemNotFoundException("Item With name "+itemName+" not found"));
		return item;
	}

	
	public List<MenuItem> displayItems() {
		return repo.findAll();
	}


	public List<MenuItem> filterByCategory(String category) {
		try {
			Category fCategory = Category.valueOf(category.toUpperCase());
			
			return repo.findItemInCategory(category.toUpperCase());
		}
		
		catch (Exception e) {
			throw new InvalidCategoryException("Category "+category+" not Found");

		}
		
	}

}
