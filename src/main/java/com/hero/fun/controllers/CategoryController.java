package com.hero.fun.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hero.fun.models.Category;
import com.hero.fun.repositories.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value="/ca/category", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Iterable<Category>> getAllCategories(){
		Iterable<Category> categories = categoryRepository.findAll();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ca/categoryadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveCategory(@RequestParam("typename") String typename, @RequestParam("description") String description){
		Category category = new Category(typename, description);
		Object result = categoryRepository.save(category);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ca/categoryadd2", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveCategory2(@RequestBody Category category){
		Object result = categoryRepository.save(category);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
