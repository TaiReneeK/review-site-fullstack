package com.example.reviewsitefullstack;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
	
	@Resource
	private CommentRepository commentRepo;
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@RequestMapping("/add-comment")
	public String addComment(String author, Long reviewId, String content) {
		Optional<Review> reviewResult = reviewRepo.findById(reviewId);
		Review review = reviewResult.get();
		
		Comment newComment = new Comment(author, review, content);
		commentRepo.save(newComment);
		
		return "redirect:/review?id=" + reviewId;
	}
	
	@RequestMapping("/remove-comment")
	public String removeCommentButton(@RequestParam Long commentId, @RequestParam Long reviewId) {
		Optional<Comment> commentToRemoveResult = commentRepo.findById(commentId);
		Comment commentToRemove = commentToRemoveResult.get();
		
		Optional<Review> reviewResult = reviewRepo.findById(reviewId);
		Review review = reviewResult.get();
		
		review.removeComment(commentToRemove);
		reviewRepo.save(review);
		
		return "redirect:/review?id=" + reviewId;
	}

}
