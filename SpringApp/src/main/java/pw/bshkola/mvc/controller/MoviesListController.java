package pw.bshkola.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class MoviesListController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "moviesList";

	}
	
}

/*@Controller
@RequestMapping(value="/movies")
public class MoviesListController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getMoviesList(ModelAndView model) {
		List<String> moviesList = new ArrayList<String>();

		moviesList.add("Fast and Furious");
		moviesList.add("Hobbit: Desolation of Smaug");
		moviesList.add("Inception");
		moviesList.add("Lord of the Rings: Return of the King");
		moviesList.add("The Dark Knight");
		
		model.addObject("moviesList", moviesList);
		model.setViewName("moviesList");
		return model;
	}
	
}
*/