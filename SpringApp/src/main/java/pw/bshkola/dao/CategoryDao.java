package pw.bshkola.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pw.bshkola.model.Category;

@Component("categoryDao")
public class CategoryDao extends BaseDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Category> findAll() {
		Session session = getSession();
		List<Category> categories = (List<Category>) session.createQuery("from Category").list();
		
		return categories;
	}
	
}

//List<Category> categories = (List<Category>) session.createCriteria(Category.class).list();