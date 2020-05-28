package com.spring.test.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.model.Rating;
import com.spring.test.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@RequestMapping("/{movieid}")
	public Rating getRating(@PathVariable("movieid") String movieId){
		
		System.out.println("movieId: "+movieId);
		Rating rating = new Rating(movieId,5);
		
		return rating;
	}
	
	@RequestMapping("/users/{userid}")
	public UserRating getUserRating(@PathVariable("userid") String userId){
		
		System.out.println("userid: "+userId);
		
		UserRating userRating = new UserRating();
		userRating.setRatings(Arrays.asList(
				new Rating("111",4),
				new Rating("222",3),
				new Rating("333",5)
				));
		
		return userRating;
	}
	
}
