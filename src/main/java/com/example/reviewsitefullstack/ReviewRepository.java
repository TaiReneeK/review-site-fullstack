package com.example.reviewsitefullstack;

import java.util.Collection;

import org.junit.experimental.categories.Categories;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> 
{

//	Collection<Review> findByCategoriesContains(Category category);

}
