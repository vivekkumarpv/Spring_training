package com.ust.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.foodapp.model.MenuItem;
import com.ust.foodapp.service.FoodAppService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/foodapp")
public class FoodAppRestController {
	
	@Autowired
	private FoodAppService service;
	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping
	public List<MenuItem> displayItems(){
		return service.displayItems();
	}
	
	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping
	public MenuItem addItem(@RequestBody MenuItem item) {
		return service.addItem(item);
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping("/name/{name}")
	public MenuItem searchItemByName(@PathVariable String name) {
		return service.searchItemByName(name);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deleteItemById(@PathVariable long id) {
		service.deleteItem(id);
	}
	
	@PutMapping("/update/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public MenuItem updateItem(@PathVariable long id,@RequestBody MenuItem item) {
		return service.updateItem(id,item);
	}
	
	@GetMapping("/filter/{category}")
	@ResponseStatus(code=HttpStatus.OK)
	public List<MenuItem> filterByCategory(@PathVariable String category){
		return service.filterByCategory(category);
	}
}
