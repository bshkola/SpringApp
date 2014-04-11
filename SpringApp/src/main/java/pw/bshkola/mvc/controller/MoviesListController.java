package pw.bshkola.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pw.bshkola.mvc.model.Movie;

@Controller
@RequestMapping(value="/movies")
public class MoviesListController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		List<Movie> moviesList = new ArrayList<Movie>();

		moviesList.add(new Movie("Fast and Furious", 2001, "No description"));
		moviesList.add(new Movie("Hobbit: Desolation of Smaug", 2013, ""));
		moviesList.add(new Movie("Inception", 2010, "Very cool film"));
		moviesList.add(new Movie("Lord of the Rings: Return of the King", 2003, "Fantactic"));
		moviesList.add(new Movie("The Dark Knight", 2008, "No"));
		
		model.addAttribute("moviesList", moviesList);

		return "moviesList";
	}
	
}