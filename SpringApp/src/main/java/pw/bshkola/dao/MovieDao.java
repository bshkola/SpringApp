package pw.bshkola.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pw.bshkola.model.Movie;

@Component("movieDao")
public class MovieDao extends BaseDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Movie> findAll() {
		Session session = getSession();
		List<Movie> movies = session.createQuery("from Movie").list();
		
		return movies;
	}
	
}
