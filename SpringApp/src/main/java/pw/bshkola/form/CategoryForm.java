package pw.bshkola.form;

import org.springframework.stereotype.Component;

@Component("categoryForm")
public class CategoryForm {

	private Integer categoryId;
	
	private String name;
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public void clear() {
		setCategoryId(null);
		setName(null);
	}
	
}
