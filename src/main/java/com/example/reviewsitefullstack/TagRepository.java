package com.example.reviewsitefullstack;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> 
{

	Tag findByDescription(String tagName); //query your tags to see if they exist

}
