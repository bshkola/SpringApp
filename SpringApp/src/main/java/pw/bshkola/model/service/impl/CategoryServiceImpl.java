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
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public void save(WebCategory webCategory) throws TransactionRollbackException {
		Category category = new Category();
		convertFromWeb(webCategory, category);
		categoryDao.save(category);
	}

	@Override
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public void saveOrUpdate(WebCategory object)
			throws TransactionRollbackException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public void update(WebCategory webCategory) throws TransactionRollbackException {
		Category category = new Category();
		convertFromWeb(webCategory, category);
		categoryDao.update(category);
	}

	@Override
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public void delete(WebCategory webCategory) throws TransactionRollbackException {
		Category category = new Category();
		convertFromWeb(webCategory, category);
		categoryDao.delete(category);
	}
	
	@Override
	@Transactional(readOnly = true)
	public WebCategory findById(Integer id) {
		Category category = categoryDao.findById(id);
		WebCategory webCategory = new WebCategory();
		convertToWeb(category, webCategory);
		return webCategory;
	}
	
	@Override
	@Transactional(rollbackFor = TransactionRollbackException.class)
	public WebCategory findByName(String name) {
		WebCategory webCategory = new WebCategory();
		Category category = categoryDao.findByName(name);
		convertToWeb(category, webCategory);
		return webCategory;
	}
	
	protected void convertToWeb(Category category, WebCategory webCategory) {
		if (category != null) {
			webCategory.setCategoryId(category.getCategoryId());
			webCategory.setName(category.getName());
		}
	}
	
	protected void convertFromWeb(WebCategory webCategory, Category category) {
		category.setCategoryId(webCategory.getCategoryId());
		category.setName(webCategory.getName());
	}

}
