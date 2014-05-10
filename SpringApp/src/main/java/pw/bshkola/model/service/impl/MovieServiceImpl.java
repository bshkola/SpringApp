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
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public void save(WebMovie webMovie) throws TransactionRollbackException {
		Movie movie = new Movie();
		convertFromWeb(webMovie, movie);
		movieDao.save(movie);
	}

	@Override
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public void saveOrUpdate(WebMovie webMovie)
			throws TransactionRollbackException {
		Movie movie = new Movie();
		convertFromWeb(webMovie, movie);
		movieDao.saveOrUpdate(movie);		
	}

	@Override
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public void update(WebMovie webMovie) throws TransactionRollbackException {
		Movie movie = new Movie();
		convertFromWeb(webMovie, movie);
		movieDao.update(movie);		
	}

	@Override
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public void delete(WebMovie webMovie) throws TransactionRollbackException {
		Movie movie = new Movie();
		convertFromWeb(webMovie, movie);
		movieDao.delete(movie);		
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
	
	@Override
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public WebMovie findById(int movieId) {
		Movie movie = movieDao.findById(movieId);
		WebMovie webMovie = new WebMovie();
		convertToWeb(movie, webMovie);
		
		return webMovie;
	}
	
	@Override
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public WebMovie findByName(String name) {
		WebMovie webMovie = new WebMovie();
		Movie movie = movieDao.findByName(name);
		convertToWeb(movie, webMovie);
		return webMovie;
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
			webMovie.setCategory(webCategory);
		}
	}
	
	protected void convertFromWeb(WebMovie webMovie, Movie movie) {
		if (webMovie != null) {
			movie.setMovieId(webMovie.getMovieId());
			movie.setName(webMovie.getName());
			movie.setReleaseYear(webMovie.getReleaseYear());
			movie.setDescription(webMovie.getDescription());
			Category category = new Category();
			WebCategory webCategory = webMovie.getCategory();
			category.setCategoryId(webCategory.getCategoryId());
			category.setName(webCategory.getName());
			movie.setCategory(category);
		}
	}

}

