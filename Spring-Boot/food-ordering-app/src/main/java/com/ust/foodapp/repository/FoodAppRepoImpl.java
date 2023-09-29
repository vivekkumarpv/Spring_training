package com.ust.foodapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ust.foodapp.exceptionhandling.InvalidCategoryException;
import com.ust.foodapp.exceptionhandling.ItemNotFoundException;
import com.ust.foodapp.model.MenuItem;
import com.ust.foodapp.model.MenuItem.Category;

@Repository
public class FoodAppRepoImpl implements FoodAppRepo {
	
	List<MenuItem> itemList= new ArrayList<>();
	
	@Override
	public MenuItem addItem(MenuItem item) {
		itemList.add(item);
		return item;
	}

	@Override
	public void deleteItem(long id) {
		MenuItem delItem = null;
		for(MenuItem item: itemList) {
			if(item.getMenuItemId()==id) {
				delItem=item;
				break;
			}
		}
		if(delItem==null) {
			throw new ItemNotFoundException("Item not found");
		}
		itemList.remove(delItem);
	}

	@Override
	public MenuItem updateItem(long id, MenuItem newItem) {
		
		MenuItem oldItem=null;
		for(MenuItem item: itemList) {
			if(item.getMenuItemId()==id) {
				oldItem=item;
				break;
			}
		}
		itemList.remove(oldItem);
		oldItem.setPrice(newItem.getPrice());
		itemList.add(oldItem);
		return oldItem;
	}

	@Override
	public MenuItem searchItemByName(String name) {
		MenuItem searchItem=null;
		for(MenuItem item:itemList) {
			if(item.getItemName().equalsIgnoreCase(name)) {
				searchItem=item;
			}
		}
		if(searchItem==null) {
			throw new ItemNotFoundException("Item not found");
		}
		return searchItem;
	}

	@Override
	public List<MenuItem> displayItems() {
		return itemList;
	}

	@Override
	public List<MenuItem> filterByCategory(String category) {
		
		try {
			Category fCategory = Category.valueOf(category.toUpperCase());
			List<MenuItem> categoryList= new ArrayList<>();
			for(MenuItem item:itemList) {
				if(item.getCategory() == fCategory) {
					categoryList.add(item);
				}
			}
			return categoryList;
		}
		
		catch (Exception e) {
			throw new InvalidCategoryException("Category Not Found");

		}

		
	}

}
