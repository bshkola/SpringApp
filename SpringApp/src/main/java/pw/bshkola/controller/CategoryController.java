package pw.bshkola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pw.bshkola.model.service.CategoryService;
import pw.bshkola.model.service.model.WebCategory;

@Controller
@RequestMapping(value = "/")
public class CategoryController {

	private static final String CATEGORIES_LIST = "categoriesList";

	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showCategoriesList(ModelMap model) {
		
		List<WebCategory> categoriesList = categoryService.findAll();
		model.addAttribute(CATEGORIES_LIST, categoriesList);
		
		return "categoriesList";
	}
	
}
