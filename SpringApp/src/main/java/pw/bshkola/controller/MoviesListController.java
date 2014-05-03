package pw.bshkola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pw.bshkola.model.service.CategoryService;
import pw.bshkola.model.service.MovieService;
import pw.bshkola.model.service.model.WebCategory;
import pw.bshkola.model.service.model.WebMovie;

@Controller
@RequestMapping(value="/movies")
public class MoviesListController {
	
	private static final String CATEGORIES_LIST = "categoriesList";
	private static final String MOVIES_LIST = "moviesList";
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showCategoriesList(ModelMap model) {
		
		List<WebCategory> categoriesList = categoryService.findAll();
		model.addAttribute(CATEGORIES_LIST, categoriesList);
		
		return "categoriesList";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String showMoviesList(ModelMap model) {

		List<WebMovie> moviesList = movieService.findAll();
		
		model.addAttribute("categoryName", "All categories");
		model.addAttribute(MOVIES_LIST, moviesList);

		return "moviesList";
	}
	
	@RequestMapping(value = "{selectedCategoryName}", method = RequestMethod.GET)
	public String showMoviesList(ModelMap model, @PathVariable String selectedCategoryName) {

		List<WebMovie> moviesList = movieService.findAllByCategoryName(selectedCategoryName);
		
		model.addAttribute("categoryName", selectedCategoryName);
		model.addAttribute(MOVIES_LIST, moviesList);

		return "moviesList";
	}

}