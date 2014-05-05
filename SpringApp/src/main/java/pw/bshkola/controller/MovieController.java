package pw.bshkola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pw.bshkola.model.service.CategoryService;
import pw.bshkola.model.service.MovieService;
import pw.bshkola.model.service.exceptions.TransactionRollbackException;
import pw.bshkola.model.service.model.WebCategory;
import pw.bshkola.model.service.model.WebMovie;

@Controller
@RequestMapping(value = "/movies")
public class MovieController {
	
	private static final String MOVIES_LIST = "moviesList";

	private static final String MOVIES_LIST_JSP = "movies/index";

	private static final String MOVIES_LIST_ADD_JSP = "movies/add";
	
	@Autowired
	private MovieService movieService;

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String showMoviesList(ModelMap model) {

		List<WebMovie> moviesList = movieService.findAll();
		
		model.addAttribute("categoryName", "All categories");
		model.addAttribute(MOVIES_LIST, moviesList);

		return MOVIES_LIST_JSP;
	}
	
	@RequestMapping(value = "{selectedCategoryName}", method = RequestMethod.GET)
	public String showMoviesList(ModelMap model, @PathVariable String selectedCategoryName) {

		List<WebMovie> moviesList = movieService.findAllByCategoryName(selectedCategoryName);
		
		model.addAttribute("categoryName", selectedCategoryName);
		model.addAttribute(MOVIES_LIST, moviesList);

		return MOVIES_LIST_JSP;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addMovie(ModelMap model) {

		List<WebCategory> categoriesList = categoryService.findAll();
		WebMovie movie = new WebMovie();
		model.addAttribute("movie", movie);
		model.addAttribute("categories", categoriesList);
		
		return MOVIES_LIST_ADD_JSP;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addMovieSuccess(ModelMap model, @ModelAttribute WebMovie movie) {
		
		try {
			movieService.save(movie);
		} catch (TransactionRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:http://localhost:8080/SpringApp/movies";
	}

}