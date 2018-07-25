package com.example.reviewsitefullstack;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController 
{
	@Resource
	ReviewRepository reviewRepo;
	
	@Resource
	CategoryRepository categoryRepo;
	
	@Resource
	TagRepository tagRepo;
	
	@Resource
	CommentRepository commentRepo;

	@RequestMapping("/review")
	public String findOneReview(@RequestParam(value= "id")long reviewId, Model model) throws ReviewNotFoundException
	{
		Optional<Review> review = reviewRepo.findById(reviewId);
		
		if(review.isPresent())
		{
			model.addAttribute("reviews", review.get());
			return "review";
		}
		throw new ReviewNotFoundException();
	}
	
	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) 
	{
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/category")
	public String findOneCategory(@RequestParam(value = "id")long categoryId, Model model) throws CategoryNotFoundException
	{
		Optional<Category> category = categoryRepo.findById(categoryId);
		
		if(category.isPresent())
		{
			model.addAttribute("categories", category.get());
//			model.addAttribute("reviews", reviewRepo.findByCategoriesContains(category.get()));
			return "category";
		}
		throw new CategoryNotFoundException();
	}
	
	@RequestMapping("/show-categories")
	public String findAllCategories(Model model) 
	{
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@RequestMapping("/tag")
	public String findOneTag(@RequestParam(value = "id")long tagId, Model model) throws TagNotFoundException
	{
		Optional<Tag> tag = tagRepo.findById(tagId);
		
		if(tag.isPresent())
		{
			model.addAttribute("tags", tag.get());
			return "tag";
		}
		throw new TagNotFoundException();
	}
	
	@RequestMapping("/show-tags")
	public String findAllTags(Model model) 
	{
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}
	
	@RequestMapping("/comment")
	public String findOneComment(@RequestParam(value = "id")long commentId, long reviewId, Model model) throws CommentNotFoundException {
		Optional<Comment> comment = commentRepo.findById(commentId);
		
		if(comment.isPresent())
		{
			model.addAttribute("comments", comment.get());
			return "comment";
		}
		throw new CommentNotFoundException();
	}
	
	@RequestMapping("/show-comments")
	public String findAllComments(Model model) 
	{
		model.addAttribute("comments", commentRepo.findAll());
		return "comments";
	}

}
