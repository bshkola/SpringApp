package pw.bshkola.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pw.bshkola.model.service.CategoryService;
import pw.bshkola.model.service.exceptions.TransactionRollbackException;
import pw.bshkola.model.service.model.WebCategory;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

	private static final String CATEGORIES_LIST = "categoriesList";

	private static final String CATEGORIES_LIST_JSP = "categories/index";
	private static final String CATEGORIES_LIST_ADD_JSP = "categories/add";
	private static final String CATEGORIES_LIST_EDIT_JSP = "categories/edit";
	private static final String CATEGORIES_LIST_DELETE_JSP = "categories/delete";
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showCategoriesList(ModelMap model) {
		
		List<WebCategory> categoriesList = categoryService.findAll();
		model.addAttribute(CATEGORIES_LIST, categoriesList);
		
		return CATEGORIES_LIST_JSP;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addCategory(ModelMap model) {

		WebCategory category = new WebCategory();
		model.addAttribute("category", category);
		
		return CATEGORIES_LIST_ADD_JSP;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addCategorySuccess(ModelMap model, @ModelAttribute @Valid WebCategory category, BindingResult result) {
		
		if (result.hasErrors()) {
			model.addAttribute("category", category);

			return CATEGORIES_LIST_ADD_JSP;
		}
		
		try {
			categoryService.save(category);
		} catch (TransactionRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:http://localhost:8080/SpringApp/categories";
	}
	
	@RequestMapping(value = "edit/{category_id}", method = RequestMethod.GET)
	public String editCategory(ModelMap model, @PathVariable Integer category_id) {
		
		WebCategory category = categoryService.findById(category_id);
		model.addAttribute("category", category);
		return CATEGORIES_LIST_EDIT_JSP;
	}
	
	@RequestMapping(value = "edit/{category_id}", method = RequestMethod.POST)
	public String editCategorySuccess(ModelMap model, @ModelAttribute WebCategory category, @PathVariable Integer category_id) {
		
		try {
			categoryService.update(category);
		} catch (TransactionRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:http://localhost:8080/SpringApp/categories";
	}
	
	@RequestMapping(value = "delete/{category_id}", method = RequestMethod.GET)
	public String deleteCategory(ModelMap model, @PathVariable Integer category_id) {
		
		WebCategory category = categoryService.findById(category_id);
		model.addAttribute("category", category);
		return CATEGORIES_LIST_DELETE_JSP;
	}
	
	@RequestMapping(value = "delete/{category_id}", method = RequestMethod.POST)
	public String deleteCategorySuccess(ModelMap model, @ModelAttribute WebCategory category, @PathVariable Integer category_id) {
		
		try {
			categoryService.delete(category);
		} catch (TransactionRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:http://localhost:8080/SpringApp/categories";
	}
	
}
