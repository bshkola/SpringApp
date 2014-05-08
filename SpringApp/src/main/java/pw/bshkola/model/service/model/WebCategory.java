package pw.bshkola.model.service.model;

import org.hibernate.validator.constraints.NotBlank;


public class WebCategory {

	private int categoryId;
	
	@NotBlank
	private String name;
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
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

	
}
