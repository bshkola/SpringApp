package pw.bshkola.model.service.model;

public class WebMovie {
	
	private Integer movieId;
	private String name;
	private Integer  releaseYear;
	private String description;
	private WebCategory category;
	
	public Integer getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WebCategory getCategory() {
		return category;
	}

	public void setCategory(WebCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return name + "(" + releaseYear + "), desc: " + description;
	}
	
}
