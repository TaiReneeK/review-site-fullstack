package com.example.reviewsitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner
{
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception 
	{
		Tag hot = new Tag("hot");
		hot = tagRepo.save(hot);
		Tag cold = new Tag("cold");
		cold = tagRepo.save(cold);
		Tag red = new Tag("red");
		red = tagRepo.save(red);
		Tag white = new Tag("white");
		white = tagRepo.save(white);
		Tag dark = new Tag("dark");
		dark = tagRepo.save(dark);
		Tag green = new Tag("green");
		green = tagRepo.save(green);
		Tag alcoholic = new Tag("alcoholic");
		alcoholic = tagRepo.save(alcoholic);
		Tag nonAlcoholic = new Tag("non-alcoholic");
		nonAlcoholic = tagRepo.save(nonAlcoholic);
		
		Category coffee = new Category("coffee");
		coffee = categoryRepo.save(coffee);
		Category tea = new Category("tea");
		tea = categoryRepo.save(tea);
		Category beer = new Category("beer");
		beer = categoryRepo.save(beer);
		Category wine = new Category("wine");
		wine = categoryRepo.save(wine);
		
		reviewRepo.save(new Review("Dukin Doughnuts", "So good 24-7!", " ", coffee, hot, cold, nonAlcoholic));
		reviewRepo.save(new Review("Peppermint Tea", "It is delicious.", " ", tea, hot, cold, nonAlcoholic));
		reviewRepo.save(new Review("Guniness", "It's for the God's!", " ", beer, dark, cold, alcoholic));
		reviewRepo.save(new Review("Red Wine", "For long days...", " ", wine, red, cold, alcoholic));
	}
	
	
}
