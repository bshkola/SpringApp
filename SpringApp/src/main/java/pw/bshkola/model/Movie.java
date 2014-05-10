package pw.bshkola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "movie_seq")
	@SequenceGenerator(name = "movie_seq", sequenceName = "movie_seq")
	@Column(name = "movie_id")
	private Integer movieId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "release_year")
	private Integer releaseYear;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public Movie() {
	}

	public Movie(Integer movieId, String name, Integer releaseYear, String description, Category category) {
		this.movieId = movieId;
		this.name = name;
		this.releaseYear = releaseYear;
		this.description = description;
		this.category = category;
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return name + "(" + releaseYear + "), desc: " + description;
	}

}
