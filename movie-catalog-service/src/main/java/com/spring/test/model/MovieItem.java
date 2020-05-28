package com.spring.test.model;

import lombok.Data;

@Data
public class MovieItem {

	MovieItem() {
		
	}
	
	private String movieId;
	private String name;

}