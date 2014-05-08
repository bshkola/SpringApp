package pw.bshkola.model.service;

import java.util.List;

import pw.bshkola.model.service.model.WebMovie;

public interface MovieService extends Service<WebMovie>{

	public List<WebMovie> findAllByCategoryName(String name);

	public WebMovie findById(int movieId);
	
}
