package com.ust.foodapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="menu_item")
public class MenuItem {
	@Id
	private long menuItemId;
	@Column(name="item_name",length=50,nullable=false,unique=true)
	private String itemName;
	@Enumerated(EnumType.STRING)
	private Status status;
	private double price;
	@Enumerated(EnumType.STRING)
	private Category category;
	public enum Status{AVAILABLE,NOTAVAILABLE;}
	public enum Category{VEG,NONVEG;}
	
	
}
