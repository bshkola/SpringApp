package pw.bshkola.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
import pw.bshkola.validator.MovieValidator;

@Controller
@RequestMapping(value = "/movies")
public class MovieController {
	
	private static final String MOVIES_LIST = "moviesList";

	private static final String MOVIES_LIST_JSP = "movies/index";

	private static final String MOVIES_LIST_ADD_JSP = "movies/add";
	private static final String MOVIES_LIST_EDIT_JSP = "movies/edit";
	private static final String MOVIES_LIST_DELETE_JSP = "movies/delete";
	
	private static final String UPLOAD_DIR = "uploadDir";

	private static final Logger logger = Logger.getLogger(MovieForm.class);
	
	@Autowired
	private MovieService movieService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private MovieForm movieForm;
	
	@Autowired
	private MovieValidator movieValidator;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String showMoviesList(ModelMap model) {

		List<WebMovie> moviesList = movieService.findAll();
		
		model.addAttribute("categoryName", "All categories");
		model.addAttribute(MOVIES_LIST, moviesList);
		
		logger.info(moviesList.get(0).getImagePath());
		for (WebMovie webMovie : moviesList) {
			logger.info(webMovie);
		}
		model.addAttribute("imagePath", moviesList.get(0).getImagePath());
		
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
	public String addMovieSuccess(ModelMap model, @ModelAttribute @Valid MovieForm movieForm, BindingResult result) {
		
		logger.info(movieForm);
		movieValidator.validate(movieForm, result);
		if (result.hasErrors()) {
			model.addAttribute("movieForm", movieForm);
			
			List<WebCategory> categoriesList = categoryService.findAll();
			model.addAttribute("categories", categoriesList);
			
			return MOVIES_LIST_ADD_JSP;
		}
		
		try {
			WebMovie webMovie = new WebMovie();
			webMovie.setName(movieForm.getName());
			webMovie.setReleaseYear(movieForm.getReleaseYear());
			webMovie.setDescription(movieForm.getDescription());
			webMovie.setCategory(categoryService.findById(movieForm.getCategory()));
			
			String filename = movieForm.getImage().getOriginalFilename();
			String filenameWithPath = "C:\\apache-tomcat-7.0.52\\webapps\\uploadDir" + File.separator + filename;
			
			File serverFile = new File(filenameWithPath);
			byte[] bytes = movieForm.getImage().getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
			        new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			
			webMovie.setImagePath(filename);
			movieService.save(webMovie);
		} catch (TransactionRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
	public String addMovieSuccess(ModelMap model, @ModelAttribute @Valid MovieForm movie, @PathVariable int movieId, BindingResult result) {
		
		movieValidator.validate(movie, result);
		if (result.hasErrors()) {
			List<WebCategory> categoriesList = categoryService.findAll();
			model.addAttribute("movieForm", movieForm);
			model.addAttribute("categories", categoriesList);
			
			return MOVIES_LIST_EDIT_JSP;
		}
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