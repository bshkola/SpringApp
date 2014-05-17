package pw.bshkola.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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
	
	private static final Logger logger = Logger.getLogger(MovieValidator.class);

	private static final List<String> imageExtensionsList = new ArrayList<String>();; 
	static {
		imageExtensionsList.add(".jpg");
		imageExtensionsList.add(".bmp");
		imageExtensionsList.add(".img");
	}
	
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
			errors.rejectValue("name", "form.duplicateMovie");
		}
		
		if (!errors.hasFieldErrors("releaseYear")) {
			if (movieForm.getReleaseYear() == null || movieForm.getReleaseYear() < 1900 || movieForm.getReleaseYear() > 2030) {
				errors.rejectValue("releaseYear", "form.outOfRange");
			}
		}

//		logger.info("MOVIE:");
//		logger.info(movieForm);
//		logger.info(movieForm.getImage().getSize());
//		logger.info(movieForm.getImage().getName());
//		logger.info(movieForm.getImage().getOriginalFilename());
//		
		if (movieForm.getMovieId() == null && movieForm.getImage().getSize() != 0) {
			boolean extensionCorrect = false;
			for (String imageExtension : imageExtensionsList) {
				if (movieForm.getImage().getOriginalFilename().endsWith(imageExtension)) {
					extensionCorrect = true;
				}
			}
			if (!extensionCorrect) {
				errors.rejectValue("image", "form.incorrectImageExtension");
			}
		}
	}
	
}
