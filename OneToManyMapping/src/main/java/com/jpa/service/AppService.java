package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Category;
import com.jpa.entity.Product;
import com.jpa.repository.CategoryRepository;
import com.jpa.repository.ProductRepository;

@Service
public class AppService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public Category saveCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	
	public List<Category> getAllCategory(){
		return this.categoryRepository.findAll();
	}

	public Category getCategory(Integer id) {
		return this.categoryRepository.findById(id).get();
	}

	public String deleteCategory(Integer id) {
		
		setCategoryForeignKeyToNull(id);
		this.categoryRepository.deleteById(id);
		return "Category Deleted";
	}

	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	
	public List<Product> getAllProduct(){
		return this.productRepository.findAll();
	}

	public Product getProduct(Integer id) {
		return this.productRepository.findById(id).orElseThrow();
	}


	public void deleteProduct(Integer id) {
		this.productRepository.deleteById(id);
		
	}
	
	
	public void setCategoryForeignKeyToNull(Integer categoryId) {
		
		List<Product> products= this.categoryRepository.findById(categoryId).get().getProducts();
		for(Product product:products) {
			product.setCategory(null);
			this.productRepository.save(product);
		}
		
	}

}
