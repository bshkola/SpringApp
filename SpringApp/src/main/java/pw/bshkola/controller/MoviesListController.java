package pw.bshkola.controller;

import java.util.List;

import javax.swing.ListModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pw.bshkola.dao.CategoryDao;
import pw.bshkola.dao.MovieDao;
import pw.bshkola.model.Category;
import pw.bshkola.model.Movie;
import pw.bshkola.model.util.HibernateUtil;

@Controller
@RequestMapping(value="/movies")
public class MoviesListController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private MovieDao movieDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showCategoriesList(ModelMap model) {
		
		List<Category> categoriesList = categoryDao.findAll();
		model.addAttribute("categoriesList", categoriesList);
		
		return "categoriesList";
	}
	
	@RequestMapping(value = "{selectedCategoryName}", method = RequestMethod.GET)
	public String showMoviesList(ModelMap model, @PathVariable String selectedCategoryName) {

		List<Movie> moviesList = movieDao.findAll();
//		Query query = session.createQuery("from Category as c where c.name = :categoryName");
//		query.setParameter("categoryName", selectedCategoryName);
//		
		
//		Category category = (Category) query.uniqueResult();
		
		model.addAttribute("categoryName", selectedCategoryName);
		model.addAttribute("moviesList", moviesList);

		return "moviesList";
	}

}