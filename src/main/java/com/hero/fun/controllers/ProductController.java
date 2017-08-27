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

import com.hero.fun.models.Product;
import com.hero.fun.repositories.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/pr/product", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Iterable<Product>> getAllProducts(){
		Iterable<Product> products = productRepository.findAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value="/pr/productadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveCategory(@RequestParam("categoryid") long categoryid, @RequestParam("typename") String typename, @RequestParam("description") String description){
		Product product = new Product(categoryid, typename, description);
		Object result = productRepository.save(product);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/pr/productadd2", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveCategory2(@RequestBody Product product){
		Object result = productRepository.save(product);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
