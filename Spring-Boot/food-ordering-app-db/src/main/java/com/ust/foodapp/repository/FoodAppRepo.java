package com.ust.foodapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ust.foodapp.model.MenuItem;

public interface FoodAppRepo extends JpaRepository<MenuItem, Long> {

	public Optional<MenuItem> findByItemName(String itemName);

	// JPQL
	@Query("from MenuItem where Category=:category ")
	public List<MenuItem> findItemInCategory(String category);

}
