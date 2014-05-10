package pw.bshkola.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pw.bshkola.model.Category;
import pw.bshkola.model.service.exceptions.TransactionRollbackException;

@Component("categoryDao")
@SuppressWarnings("unchecked")
public class CategoryDao {

	private static final String NAME = "name";
	
	private static final String ALL_QUERY = "from Category c order by c.name";
	private static final String NAME_QUERY = "from Category c where c.name = :name";
	
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

	public void save(Category category) throws TransactionRollbackException {
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
	}

	public void update(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.update(category);
	}
	
	public void updateOrUpdate(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}
	
	public void delete(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(category);
	}
	
	public Category findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (Category) session.get(Category.class, id);
	}

	public Category findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(NAME_QUERY);
		query.setParameter(NAME, name);
		List<Category> list = query.list();
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

}
