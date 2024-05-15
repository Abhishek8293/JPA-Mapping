package com.jpa.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Category;
import com.jpa.entity.Product;
import com.jpa.service.AppService;

@RestController
public class AppController {

	@Autowired
	private AppService appService;

	@PostMapping("/add/category")
	public Category saveCategory(@RequestBody Category category) {
		return this.appService.saveCategory(category);
	}

	@GetMapping("/getall/category")
	public List<Category> getAllCategory() {
		return this.appService.getAllCategory();
	}

	@GetMapping("/get/category/{id}")
	public Category getCategory(@PathVariable Integer id) {
		return this.appService.getCategory(id);
	}

	@DeleteMapping("/delete/category/{id}")
	public String deleteCategory(@PathVariable Integer id) {
		return this.appService.deleteCategory(id);
	}

	@PostMapping("/add/product")
	public Product saveProduct(@RequestBody Product product) {
		return this.appService.saveProduct(product);
	}

	@GetMapping("/getall/product")
	public List<Product> getAllProduct() {
		return this.appService.getAllProduct();
	}

	@GetMapping("/get/product/{id}")
	public Product geProduct(@PathVariable Integer id) {

		return this.appService.getProduct(id);
	}
	
	@DeleteMapping("/delete/product/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		this.appService.deleteProduct(id);
		return "Product Deleted";
	}
	
	@GetMapping("/check/{id}")
	public void checkMethod(@PathVariable Integer id){
	 this.appService.setCategoryForeignKeyToNull(id);
	}

}
