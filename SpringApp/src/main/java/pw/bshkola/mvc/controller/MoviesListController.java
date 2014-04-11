package pw.bshkola.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/movies")
public class MoviesListController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		List<String> moviesList = new ArrayList<String>();

		moviesList.add("Fast and Furious");
		moviesList.add("Hobbit: Desolation of Smaug");
		moviesList.add("Inception");
		moviesList.add("Lord of the Rings: Return of the King");
		moviesList.add("The Dark Knight");
		
		model.addAttribute("moviesList", moviesList);

		return "moviesList";

	}
	
}