package pw.bshkola.model.service;

import pw.bshkola.model.service.model.WebCategory;

public interface CategoryService extends Service<WebCategory>{

	public WebCategory findById(Integer id);

	public WebCategory findByName(String name);
	
}
