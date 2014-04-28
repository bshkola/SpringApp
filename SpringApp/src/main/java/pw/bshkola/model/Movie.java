package pw.bshkola.model;

public class Movie {

	private int movieId;
	private String name;
	private int releaseYear;
	private String description;
	private MovieCategory category;
	
	public Movie() {
	}

	public Movie(int movieId, String name, int releaseYear, String description, MovieCategory category) {
		this.setMovieId(movieId);
		this.name = name;
		this.releaseYear = releaseYear;
		this.description = description;
		this.category = category;
	}

	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
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

	public MovieCategory getCategory() {
		return category;
	}

	public void setDescription(MovieCategory category) {
		this.category = category;
	}

}
