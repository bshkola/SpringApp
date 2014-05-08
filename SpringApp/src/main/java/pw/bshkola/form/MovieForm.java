package pw.bshkola.form;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Component("movieForm")
public class MovieForm {
	
	private Integer movieId;
	
	@NotBlank
	private String name;
	
	@Range(min = 1900, max = 2030)
	private Integer releaseYear;
	private String description;
	private Integer category;
	
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

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return name + "(" + releaseYear + "), desc: " + description;
	}
	
	public void clear() {
		setMovieId(null);
		setName(null);
		setReleaseYear(null);
		setDescription(null);
		setCategory(null);
	}
	
}