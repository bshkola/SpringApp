package pw.bshkola.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "category_seq")
	@SequenceGenerator(name = "category_seq", sequenceName = "category_seq")
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private Set<Movie> categoryMovies = new HashSet<Movie>(0);
	
	public Category() {
	}
	
	public Category(int categoryId, String name) {
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

	public Set<Movie> getCategoryMovies() {
		return categoryMovies;
	}

	public void setCategoryMovies(Set<Movie> categoryMovies) {
		this.categoryMovies = categoryMovies;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
