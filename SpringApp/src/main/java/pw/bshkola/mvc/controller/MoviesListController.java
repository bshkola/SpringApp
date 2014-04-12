package pw.bshkola.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pw.bshkola.mvc.model.Movie;
import pw.bshkola.mvc.model.MovieCategory;

@Controller
@RequestMapping(value="/movies")
public class MoviesListController {
	
	private static List<Movie> globalMoviesList = new ArrayList<Movie>();

	static {
		globalMoviesList.add(new Movie("Fast and Furious", 2001, "No description", new MovieCategory("Action")));
		globalMoviesList.add(new Movie("Hobbit: Desolation of Smaug", 2013, "", new MovieCategory("Fantasy")));
		globalMoviesList.add(new Movie("Inception", 2010, "Very cool film", new MovieCategory("Action")));
		globalMoviesList.add(new Movie("Lord of the Rings: Return of the King", 2003, "Fantactic", new MovieCategory("Fantasy")));
		globalMoviesList.add(new Movie("The Dark Knight", 2008, "No", new MovieCategory("Action")));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showCategoriesList(ModelMap model) {
		List<MovieCategory> categoriesList = new ArrayList<MovieCategory>();
		categoriesList.add(new MovieCategory("Fantasy"));
		categoriesList.add(new MovieCategory("Action"));
				
		model.addAttribute("categoriesList", categoriesList);

		return "categoriesList";
	}
	
	@RequestMapping(value = "{categoryName}", method = RequestMethod.GET)
	public String showMoviesList(ModelMap model, @PathVariable String categoryName) {
		List<Movie> moviesList = new ArrayList<Movie>();
		
		for (Movie movie : globalMoviesList) {
			if (movie.getCategory().getName().equals(categoryName)) {
				moviesList.add(movie);
			}
		}

		model.addAttribute("categoryName", categoryName);
		model.addAttribute("moviesList", moviesList);

		return "moviesList";
	}
	
}