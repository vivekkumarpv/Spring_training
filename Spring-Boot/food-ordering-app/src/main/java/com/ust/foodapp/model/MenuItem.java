package com.ust.foodapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
	private long menuItemId;
	private String itemName;
	private Status status;
	private double price;
	private Category category;
	public enum Status{AVAILABLE,NOTAVAILABLE;}
	public enum Category{VEG,NONVEG;}
	
	
}
