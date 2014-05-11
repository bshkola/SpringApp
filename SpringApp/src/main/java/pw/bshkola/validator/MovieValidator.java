package pw.bshkola.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pw.bshkola.form.MovieForm;
import pw.bshkola.model.service.MovieService;
import pw.bshkola.model.service.model.WebMovie;

@Component("movieValidator")
public class MovieValidator implements Validator {
	
	@Autowired
	private MovieService movieService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MovieForm.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "form.fieldRequired");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "releaseYear", "form.fieldRequired");
		
		MovieForm movieForm = (MovieForm) target;
		WebMovie webMovie = movieService.findByName(movieForm.getName());
		if ((webMovie.getMovieId() != null) && (webMovie.getMovieId() != movieForm.getMovieId())) {
			errors.rejectValue("name", "form.duplicateCategory");
		}
		
		if (!errors.hasFieldErrors("releaseYear")) {
			if (movieForm.getReleaseYear() == null || movieForm.getReleaseYear() < 1900 || movieForm.getReleaseYear() > 2030) {
				errors.rejectValue("releaseYear", "form.outOfReleaseYearRange");
			}
		}
	}
	
}
