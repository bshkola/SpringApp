package pw.bshkola.model;

public class MovieCategory {
	
	private int categoryId;
	private String name;
	
	public MovieCategory(int categoryId, String name) {
		this.setCategoryId(categoryId);
		this.name = name;
	}

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

}
