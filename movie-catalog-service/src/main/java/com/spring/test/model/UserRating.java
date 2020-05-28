package com.spring.test.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserRating {

	UserRating(){}
	
	private List<Rating> ratings = new ArrayList<Rating>();
	
}
