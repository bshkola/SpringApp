package pw.bshkola.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.bshkola.model.Category;

@Component("categoryDao")
@SuppressWarnings("unchecked")
public class CategoryDao {

	private static final String ALL_QUERY = "from Category c order by c.name";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Category> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Category> list = (List<Category>) session.createQuery(ALL_QUERY).list();
		if (list == null) {
			return new ArrayList<Category>();
		}
		return list;
	}
	
}
