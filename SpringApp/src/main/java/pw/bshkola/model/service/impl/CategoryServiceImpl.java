package pw.bshkola.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pw.bshkola.dao.CategoryDao;
import pw.bshkola.model.Category;
import pw.bshkola.model.service.CategoryService;
import pw.bshkola.model.service.exceptions.TransactionRollbackException;
import pw.bshkola.model.service.model.WebCategory;

@Component("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<WebCategory> findAll() {
		List<WebCategory> webCategoryList = new ArrayList<WebCategory>();
		List<Category> categoryList = categoryDao.findAll();
		for (Category category : categoryList) {
			WebCategory webCategory = new WebCategory();
			convertToWeb(category, webCategory);
			webCategoryList.add(webCategory);
		}
		return webCategoryList;
	}


	@Override
	public void save(WebCategory object) throws TransactionRollbackException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void saveOrUpdate(WebCategory object)
			throws TransactionRollbackException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update(WebCategory object) throws TransactionRollbackException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(WebCategory object) throws TransactionRollbackException {
		// TODO Auto-generated method stub
		
	}
	
	protected void convertToWeb(Category category, WebCategory webCategory) {
		if (category != null) {
			webCategory.setCategoryId(category.getCategoryId());
			webCategory.setName(category.getName());
		}
	}

}
