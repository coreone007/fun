package com.hero.fun.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hero.fun.models.Product;


public interface ProductRepository extends CrudRepository<Product, Long>{

}
