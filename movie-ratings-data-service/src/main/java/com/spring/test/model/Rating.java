package com.spring.test.model;

import lombok.Data;

@Data
public class Rating {

	public Rating(String movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}
	
	private String movieId;
	private int rating;
	
}
