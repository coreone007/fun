package com.hero.fun.repositories;

import org.springframework.data.repository.CrudRepository;
import com.hero.fun.models.Category;

public interface CategoryRepository  extends CrudRepository<Category, Long>{

}
