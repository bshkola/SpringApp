package pw.bshkola.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.bshkola.model.Movie;

@SuppressWarnings("unchecked")
@Component("movieDao")
public class MovieDao {

	private static final String CATEGORY_NAME = "category_name";

	private static final String ALL_QUERY = "from Movie m order by m.name";
	private static final String CATEGORY_NAME_QUERY = "from Movie m where m.category.name = :category_name order by m.name";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Movie> findAllByCategoryName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(CATEGORY_NAME_QUERY);
		query.setParameter(CATEGORY_NAME, name);
		
		List<Movie> movies = query.list();
		if (movies == null) {
			return new ArrayList<Movie>();
		}
		return movies;
	}

	public List<Movie> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Movie> movies = session.createQuery(ALL_QUERY).list();
		
		if (movies == null) {
			return new ArrayList<Movie>();
		}
		return movies;
	}
	
	public Movie findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Movie) session.get(Movie.class, id);
	}

	public void save(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.save(movie);
	}

	public void saveOrUpdate(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(movie);
	}

	public void update(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.update(movie);
	}

	public void delete(Movie movie) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(movie);
	}
	
}
