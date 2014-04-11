package pw.bshkola.mvc.model;


public class Movie {

	private String name;
	private int releaseYear;
	private String description;
	
	public Movie() {
	}

	public Movie(String name, int releaseYear, String description) {
		this.name = name;
		this.releaseYear = releaseYear;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
