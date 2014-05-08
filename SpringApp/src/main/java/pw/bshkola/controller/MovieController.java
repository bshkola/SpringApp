package pw.bshkola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pw.bshkola.form.MovieForm;
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
	private static final String MOVIES_LIST_EDIT_JSP = "movies/edit";
	private static final String MOVIES_LIST_DELETE_JSP = "movies/delete";
	
	@Autowired
	private MovieService movieService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MovieForm movieForm;
	
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

		movieForm.clear();
		
		model.addAttribute("movieForm", movieForm);
		model.addAttribute("categories", categoriesList);
		
		return MOVIES_LIST_ADD_JSP;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addMovieSuccess(ModelMap model, @ModelAttribute MovieForm movie) {
		
		try {
			WebMovie webMovie = new WebMovie();
			webMovie.setMovieId(0);
			webMovie.setName(movie.getName());
			webMovie.setReleaseYear(movie.getReleaseYear());
			webMovie.setDescription(movie.getDescription());
			webMovie.setCategory(categoryService.findById(movie.getCategory()));
			
			movieService.save(webMovie);
		} catch (TransactionRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:http://localhost:8080/SpringApp/categories/";
	}
	
	@RequestMapping(value = "edit/{movieId}", method = RequestMethod.GET)
	public String editMovie(ModelMap model, @PathVariable int movieId) {

		List<WebCategory> categoriesList = categoryService.findAll();

		WebMovie webMovie = movieService.findById(movieId);

		movieForm.clear();
		movieForm.setMovieId(webMovie.getMovieId());
		movieForm.setName(webMovie.getName());
		movieForm.setReleaseYear(webMovie.getReleaseYear());
		movieForm.setDescription(webMovie.getDescription());
		movieForm.setCategory(webMovie.getCategory().getCategoryId());
		
		model.addAttribute("movieForm", movieForm);
		model.addAttribute("categories", categoriesList);
		
		return MOVIES_LIST_EDIT_JSP;
	}
	
	@RequestMapping(value = "edit/{movieId}", method = RequestMethod.POST)
	public String addMovieSuccess(ModelMap model, @ModelAttribute MovieForm movie, @PathVariable int movieId) {
		
		try {
			WebMovie webMovie = new WebMovie();
			webMovie.setMovieId(movie.getMovieId());
			webMovie.setName(movie.getName());
			webMovie.setReleaseYear(movie.getReleaseYear());
			webMovie.setDescription(movie.getDescription());
			webMovie.setCategory(categoryService.findById(movie.getCategory()));
			
			movieService.update(webMovie);
		} catch (TransactionRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:http://localhost:8080/SpringApp/categories/";
	}
	
	@RequestMapping(value = "delete/{movieId}", method = RequestMethod.GET)
	public String deleteMovie(ModelMap model, @PathVariable int movieId) {

		List<WebCategory> categoriesList = categoryService.findAll();

		WebMovie webMovie = movieService.findById(movieId);

		movieForm.clear();
		movieForm.setMovieId(webMovie.getMovieId());
		movieForm.setName(webMovie.getName());
		movieForm.setReleaseYear(webMovie.getReleaseYear());
		movieForm.setDescription(webMovie.getDescription());
		movieForm.setCategory(webMovie.getCategory().getCategoryId());
		
		model.addAttribute("movieForm", movieForm);
		model.addAttribute("categories", categoriesList);
		
		return MOVIES_LIST_DELETE_JSP;
	}
	
	@RequestMapping(value = "delete/{movieId}", method = RequestMethod.POST)
	public String deleteMovieSuccess(ModelMap model, @ModelAttribute MovieForm movie, @PathVariable int movieId) {
		
		try {
			movieService.delete(movieService.findById(movieId));
		} catch (TransactionRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:http://localhost:8080/SpringApp/categories/";
	}

}