package pw.bshkola.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pw.bshkola.dao.MovieDao;
import pw.bshkola.model.Category;
import pw.bshkola.model.Movie;
import pw.bshkola.model.service.MovieService;
import pw.bshkola.model.service.exceptions.TransactionRollbackException;
import pw.bshkola.model.service.model.WebCategory;
import pw.bshkola.model.service.model.WebMovie;

@Component("movieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<WebMovie> findAll() {
		List<WebMovie> webMovieList = new ArrayList<WebMovie>();
		List<Movie> movieList = movieDao.findAll();
		for (Movie movie : movieList) {
			WebMovie webMovie = new WebMovie();
			convertToWeb(movie, webMovie);
			webMovieList.add(webMovie);
		}
		return webMovieList;
	}
	
	@Override
	public void save(WebMovie object) throws TransactionRollbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(WebMovie object)
			throws TransactionRollbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(WebMovie object) throws TransactionRollbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(WebMovie object) throws TransactionRollbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<WebMovie> findAllByCategoryName(String name) {
		List<WebMovie> webMovieList = new ArrayList<WebMovie>();
		List<Movie> movieList = movieDao.findAllByCategoryName(name);
		for (Movie movie : movieList) {
			WebMovie webMovie = new WebMovie();
			convertToWeb(movie, webMovie);
			webMovieList.add(webMovie);
		}
		return webMovieList;
	}
	
	protected void convertToWeb(Movie movie, WebMovie webMovie) {
		if (movie != null) {
			webMovie.setMovieId(movie.getMovieId());
			webMovie.setName(movie.getName());
			webMovie.setReleaseYear(movie.getReleaseYear());
			webMovie.setDescription(movie.getDescription());
			WebCategory webCategory = new WebCategory();
			Category category = movie.getCategory();
			webCategory.setCategoryId(category.getCategoryId());
			webCategory.setName(category.getName());
		}
	}

}

