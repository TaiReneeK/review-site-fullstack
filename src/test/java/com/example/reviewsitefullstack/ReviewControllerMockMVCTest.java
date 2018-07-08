package com.example.reviewsitefullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMVCTest 
{
	@Resource
	private MockMvc mvc;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@Mock
	private Review review1;
	
	@Mock
	private Review review2;
	
	@MockBean
	private CategoryRepository categoryRepo;
	
	@Mock
	private Category category1;
	
	@Mock
	private Category category2;
	
	@MockBean
	private TagRepository tagRepo;
	
	@Mock
	private Tag tag1;
	
	@Mock
	private Tag tag2;

	@Test //Do for tag and category as well
	public void shouldRouteToSingleReviewView() throws Exception
	{
		long reviewId = 1;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review1));
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
	}
	
	@Test
	public void shouldRouteToAllReviewView() throws Exception
	{
		mvc.perform(get("/show-reviews")).andExpect(view().name(is("reviews")));
	}
	
	@Test
	public void shouldBeOkForASingleReview() throws Exception
	{
		long reviewId = 1;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review1));
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldBeOkForAllReviews() throws Exception
	{
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldPutAllReviewsIntoModel() throws Exception
	{
		Collection<Review> allReviews = Arrays.asList(review1, review2);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteSingleCategoryToView() throws Exception
	{
		long categoryId = 1;
		when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(category1));
		mvc.perform(get("/category?id=1")).andExpect(view().name(is("category")));
	}
	
	@Test
	public void shouldRouteToAllCategoriesView() throws Exception
	{
		mvc.perform(get("/show-categories")).andExpect(view().name(is("categories")));
	}
	
	@Test
	public void shouldBeOkForASingleCategory() throws Exception
	{
		long categoryId = 1;
		when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(category1));
		mvc.perform(get("/category?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldBeOkForAllCategories() throws Exception
	{
		mvc.perform(get("/show-categories")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldPutAllCategoriesIntoModel() throws Exception
	{
		Collection<Category> allCategories = Arrays.asList(category1, category2);
		when(categoryRepo.findAll()).thenReturn(allCategories);
		
		mvc.perform(get("/show-categories")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRouteSingleTagToView() throws Exception
	{
		long tagId = 1;
		when(tagRepo.findById(tagId)).thenReturn(Optional.of(tag1));
		mvc.perform(get("/tag?id=1")).andExpect(view().name(is("tag")));
	}
	
	@Test
	public void shouldRouteToAllTagsView() throws Exception
	{
		mvc.perform(get("/show-tags")).andExpect(view().name(is("tags")));
	}
	
	@Test
	public void shouldBeOkForASingleTag() throws Exception
	{
		long tagId = 1;
		when(tagRepo.findById(tagId)).thenReturn(Optional.of(tag1));
		mvc.perform(get("/tag?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldBeOkForAllTags() throws Exception
	{
		mvc.perform(get("/show-tags")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldPutAllTagsIntoModel() throws Exception
	{
		Collection<Tag> allTags = Arrays.asList(tag1, tag2);
		when(tagRepo.findAll()).thenReturn(allTags);
		
		mvc.perform(get("/show-tags")).andExpect(status().isOk());
	}
}
