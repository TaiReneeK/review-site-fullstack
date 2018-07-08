package com.example.reviewsitefullstack;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ReviewControllerTest 
{
	@InjectMocks //enables mock objects to be placed into controller
	private ReviewController underTest;
	
	@Mock
	private ReviewRepository reviewRepo;
	
	@Mock
	private Review review1;
	
	@Mock
	private Review review2;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Category category1;
	
	@Mock
	private Category category2;
	
	@Mock
	private TagRepository tagRepo;
	
	@Mock
	private Tag tag1;
	
	@Mock
	private Tag tag2;
	
	@Mock
	private Model model;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddSingleReviewToModel() throws ReviewNotFoundException
	{
		long review1Id = 1;
		when(reviewRepo.findById(review1Id)).thenReturn(Optional.of(review1));
		
		underTest.findOneReview(review1Id, model);
		verify(model).addAttribute("reviews", review1);
	}
	
	@Test
	public void shouldAddAllReviewsToModel() throws ReviewNotFoundException
	{
		Collection<Review> allReviews = Arrays.asList(review1, review2);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		
		underTest.findAllReviews(model);
	}
	
	@Test
	public void shouldAddSingleCategoryToModel() throws CategoryNotFoundException
	{
		long category1Id = 1;
		when(categoryRepo.findById(category1Id)).thenReturn(Optional.of(category1));
		
		underTest.findOneCategory(category1Id, model);
		verify(model).addAttribute("categories", category1);
	}
	
	@Test
	public void shouldAddAllCategoriesToModel() throws CategoryNotFoundException
	{
		Collection<Category> allCategories = Arrays.asList(category1, category2);
		when(categoryRepo.findAll()).thenReturn(allCategories);
		
		underTest.findAllCategories(model);
		verify(model).addAttribute("categories", allCategories);
	}
	
	@Test
	public void shouldAddSingleTagToModel() throws TagNotFoundException
	{
		long tag1Id = 1;
		when(tagRepo.findById(tag1Id)).thenReturn(Optional.of(tag1));
		
		underTest.findOneTag(tag1Id, model);
		verify(model).addAttribute("tags", tag1);
	}
	
	@Test
	public void shouldAddAllTagsToModel() throws TagNotFoundException
	{
		Collection<Tag> allTags = Arrays.asList(tag1, tag2);
		when(tagRepo.findAll()).thenReturn(allTags);
		
		underTest.findAllTags(model);
		verify(model).addAttribute("tags", allTags);
	}
}
