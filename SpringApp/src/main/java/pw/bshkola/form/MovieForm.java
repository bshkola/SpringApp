package pw.bshkola.form;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component("movieForm")
public class MovieForm {
	
	private Integer movieId;
	private String name;
	private Integer releaseYear;
	private String description;
	private Integer category;
	private CommonsMultipartFile file;
	
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

	public CommonsMultipartFile getFile() {
		return file;
	}
	
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
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
		setFile(null);
	}

}
