package pw.bshkola.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pw.bshkola.form.CategoryForm;
import pw.bshkola.model.service.CategoryService;
import pw.bshkola.model.service.model.WebCategory;

@Component("categoryValidator")
public class CategoryValidator implements Validator {
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoryForm.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "form.fieldRequired");
		
		CategoryForm categoryForm = (CategoryForm) target;
		WebCategory webCategory = categoryService.findByName(categoryForm.getName());
		if ((webCategory.getCategoryId() != null) && (webCategory.getCategoryId() != categoryForm.getCategoryId())) {
			errors.rejectValue("name", "form.duplicateCategory");
		}
	}

}
