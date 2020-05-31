package com.spring.test.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.model.MovieItem;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@RequestMapping("/{movieid}")
	public MovieItem getMovieInfo(@PathVariable("movieid") String movieId) {
		
		MovieItem movie = new MovieItem();
		movie.setMovieId("foo");
		movie.setName("Test Name - "+movieId);
		//return Collections.singletonList(movie);
		return movie;
	}


	
}
