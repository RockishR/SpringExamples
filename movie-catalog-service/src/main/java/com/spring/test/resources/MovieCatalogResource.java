package com.spring.test.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.spring.test.model.CatalogItem;
import com.spring.test.model.MovieItem;
import com.spring.test.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userid}")
	public List<CatalogItem> getCtalog(@PathVariable("userid") String userId) {

		UserRating userRating = restTemplate.getForObject("http://movie-ratings-service/ratingsdata/users/"+userId, UserRating.class);

		return userRating.getRatings().stream().map(r -> {
			MovieItem movie =
			restTemplate.getForObject("http://movie-info-service/movies/"+r.getMovieId(),
					MovieItem.class);
			 
			/*
			 * MovieItem movie =
			 * webClientBuilder.build().get().uri("http://localhost:8082/movies/" +
			 * r.getMovieId()) .retrieve().bodyToMono(MovieItem.class).block();
			 */
			
			CatalogItem cat = new CatalogItem();
			cat.setName(movie.getName());
			cat.setDesc("Test desc2");
			cat.setRating(r.getRating());
			return cat;

		}).collect(Collectors.toList());

	}
}
